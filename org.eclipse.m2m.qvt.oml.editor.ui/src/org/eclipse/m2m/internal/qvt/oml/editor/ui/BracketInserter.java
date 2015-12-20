/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.Stack;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.link.ILinkedModeListener;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedModeUI;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;
import org.eclipse.jface.text.link.LinkedModeUI.IExitPolicy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.link.EditorLinkedModeUI;

/**
 * This class is used for automatic bracket (and dollar sign) closing and for
 * replacement of quotation marks. Most parts are copied from the Eclipse JDT.
 */
public class BracketInserter implements VerifyKeyListener, ILinkedModeListener {

	private class ExitPolicy implements IExitPolicy {

		final char fExitCharacter;

		final char fEscapeCharacter;

		final Stack<BracketLevel> fStack;

		final int fSize;

		final ISourceViewer sourceViewer;

		public ExitPolicy(char exitCharacter, char escapeCharacter, Stack<BracketLevel> stack, ISourceViewer viewer) {
			fExitCharacter = exitCharacter;
			fEscapeCharacter = escapeCharacter;
			fStack = stack;
			fSize = fStack.size();
			sourceViewer = viewer;
		}

		/*
		 * @see org.eclipse.jdt.internal.ui.text.link.LinkedPositionUI.ExitPolicy#doExit(org.eclipse.jdt.internal.ui.text.link.LinkedPositionManager,
		 *      org.eclipse.swt.events.VerifyEvent, int, int)
		 */
		public ExitFlags doExit(LinkedModeModel model, VerifyEvent event, int offset, int length) {

			if (fSize == fStack.size() && !isMasked(offset)) {
				if (event.character == fExitCharacter) {
					BracketLevel level = (BracketLevel) fStack.peek();
					if (level.fFirstPosition.offset > offset || level.fSecondPosition.offset < offset)
						return null;
					if (level.fSecondPosition.offset == offset && length == 0)
						// don't enter the character if if its the closing peer
						return new ExitFlags(ILinkedModeListener.UPDATE_CARET, false);
				}
				// when entering an anonymous class between the parenthesis', we
				// don't want
				// to jump after the closing parenthesis when return is pressed
				if (event.character == SWT.CR && offset > 0) {
					IDocument document = sourceViewer.getDocument();
					try {
						if (document.getChar(offset - 1) == '{')
							return new ExitFlags(ILinkedModeListener.EXIT_ALL, true);
					} catch (BadLocationException e) {
					}
				}
			}
			return null;
		}

		private boolean isMasked(int offset) {
			IDocument document = sourceViewer.getDocument();
			try {
				return fEscapeCharacter == document.getChar(offset - 1);
			} catch (BadLocationException e) {
			}
			return false;
		}
	}

	private static class BracketLevel {
		LinkedModeUI fUI;

		Position fFirstPosition;

		Position fSecondPosition;
	}

	/**
	 * Position updater that takes any changes at the borders of a position to
	 * not belong to the position.
	 * 
	 * @since 3.0
	 */
	private static class ExclusivePositionUpdater implements IPositionUpdater {

		/** The position category. */
		private final String fCategory;

		/**
		 * Creates a new updater for the given <code>category</code>.
		 * 
		 * @param category
		 *            the new category.
		 */
		public ExclusivePositionUpdater(String category) {
			fCategory = category;
		}

		/*
		 * @see org.eclipse.jface.text.IPositionUpdater#update(org.eclipse.jface.text.DocumentEvent)
		 */
		public void update(DocumentEvent event) {

			int eventOffset = event.getOffset();
			int eventOldLength = event.getLength();
			int eventNewLength = event.getText() == null ? 0 : event.getText().length();
			int deltaLength = eventNewLength - eventOldLength;

			try {
				Position[] positions = event.getDocument().getPositions(fCategory);

				for (int i = 0; i != positions.length; i++) {

					Position position = positions[i];

					if (position.isDeleted())
						continue;

					int offset = position.getOffset();
					int length = position.getLength();
					int end = offset + length;

					if (offset >= eventOffset + eventOldLength)
						// position comes
						// after change - shift
						position.setOffset(offset + deltaLength);
					else if (end <= eventOffset) {
						// position comes way before change -
						// leave alone
					} else if (offset <= eventOffset && end >= eventOffset + eventOldLength) {
						// event completely internal to the position - adjust
						// length
						position.setLength(length + deltaLength);
					} else if (offset < eventOffset) {
						// event extends over end of position - adjust length
						int newEnd = eventOffset;
						position.setLength(newEnd - offset);
					} else if (end > eventOffset + eventOldLength) {
						// event extends from before position into it - adjust
						// offset
						// and length
						// offset becomes end of event, length adjusted
						// accordingly
						int newOffset = eventOffset + eventNewLength;
						position.setOffset(newOffset);
						position.setLength(end - newOffset);
					} else {
						// event consumes the position - delete it
						position.delete();
					}
				}
			} catch (BadPositionCategoryException e) {
				// ignore and return
			}
		}

	}

	public BracketInserter(ISourceViewer viewer) {
		mySourceViewer = viewer;
	}

	private static boolean hasPeerClosingCharacter(char character) {
		return character == '(' || character == '[' || character == '\'' || character == '\"';
	}

	private static char getPeerClosingCharacter(char character) {
		switch (character) {
		case '(':
			return ')';
		case '[':
			return ']';
		case '\'':
			return '\'';
		case '\"':
			return '\"';			
		}
		throw new IllegalArgumentException();
	}
	
	private static boolean isClosingCharacter(char character) {
		return character == ')' || character == ']' || character == '\'';
	}

	public void verifyKey(VerifyEvent event) {
		char character = event.character;
		if (!hasPeerClosingCharacter(character)) {
			return;
		}
		IDocument document = mySourceViewer.getDocument();

		Point selection = mySourceViewer.getSelectedRange();
		int offset = selection.x;
		int length = selection.y;

		try {
			char next = ' ';
			try {
				next = document.getChar(offset);
			} catch (BadLocationException e) {
				// ignore
			}

			if (!Character.isWhitespace(next) && !isClosingCharacter(next)) {
				return;
			}

			char closingCharacter = getPeerClosingCharacter(character);
			StringBuilder buffer = new StringBuilder();
			buffer.append(character);
			buffer.append(closingCharacter);

			document.replace(offset, length, buffer.toString());

			// The code below does the fancy "templateish" enter-to-exit-braces
			BracketLevel level = new BracketLevel();
			fBracketLevelStack.push(level);

			LinkedPositionGroup group = new LinkedPositionGroup();
			group.addPosition(new LinkedPosition(document, offset + 1, 0, LinkedPositionGroup.NO_STOP));

			LinkedModeModel model = new LinkedModeModel();
			model.addLinkingListener(this);
			model.addGroup(group);
			model.forceInstall();

			// set up position tracking for our magic peers
			if (fBracketLevelStack.size() == 1) {
				document.addPositionCategory(CATEGORY);
				document.addPositionUpdater(fUpdater);
			}
			level.fFirstPosition = new Position(offset, 1);
			level.fSecondPosition = new Position(offset + 1, 1);
			document.addPosition(CATEGORY, level.fFirstPosition);
			document.addPosition(CATEGORY, level.fSecondPosition);

			level.fUI = new EditorLinkedModeUI(model, mySourceViewer);
			level.fUI.setSimpleMode(true);
			level.fUI.setExitPolicy(new ExitPolicy(closingCharacter, (char) 0, fBracketLevelStack, mySourceViewer));
			level.fUI.setExitPosition(mySourceViewer, offset + 2, 0, Integer.MAX_VALUE);
			level.fUI.setCyclingMode(LinkedModeUI.CYCLE_NEVER);
			level.fUI.enter();

			IRegion newSelection = level.fUI.getSelectedRegion();
			mySourceViewer.setSelectedRange(newSelection.getOffset(), newSelection.getLength());

			event.doit = false;

		} catch (BadLocationException e) {
		} catch (BadPositionCategoryException e) {
		}
	}

	public void left(LinkedModeModel environment, int flags) {
		final BracketLevel level = (BracketLevel) fBracketLevelStack.pop();

		if (flags != ILinkedModeListener.EXTERNAL_MODIFICATION) {
			return;
		}

		// remove brackets
		final IDocument document = mySourceViewer.getDocument();
		if (document instanceof IDocumentExtension) {
			IDocumentExtension extension = (IDocumentExtension) document;
			extension.registerPostNotificationReplace(null, new IDocumentExtension.IReplace() {

				public void perform(IDocument d, IDocumentListener owner) {
					if ((level.fFirstPosition.isDeleted || level.fFirstPosition.length == 0)
							&& !level.fSecondPosition.isDeleted
							&& level.fSecondPosition.offset == level.fFirstPosition.offset) {
						try {
							document.replace(level.fSecondPosition.offset, level.fSecondPosition.length, null);
						} catch (BadLocationException e) {
							// ignore
						}
					}

					if (fBracketLevelStack.size() == 0) {
						document.removePositionUpdater(fUpdater);
						try {
							document.removePositionCategory(CATEGORY);
						} catch (BadPositionCategoryException e) {
							// ignore
						}
					}
				}
			});
		}
	}

	public void suspend(LinkedModeModel environment) {
	}

	public void resume(LinkedModeModel environment, int flags) {
	}

	private final String CATEGORY = toString();

	private IPositionUpdater fUpdater = new ExclusivePositionUpdater(CATEGORY);

	private Stack<BracketLevel> fBracketLevelStack = new Stack<BracketLevel>();

	private final ISourceViewer mySourceViewer;

}

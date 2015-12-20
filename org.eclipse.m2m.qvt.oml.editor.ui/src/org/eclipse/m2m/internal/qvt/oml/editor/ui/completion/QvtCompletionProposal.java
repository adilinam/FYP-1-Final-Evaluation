/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 4, 2007
 */

public class QvtCompletionProposal implements ICompletionProposal {
	/** The string to be displayed in the completion proposal popup. */
	private String fDisplayString;
	/** The replacement string. */
	private String fReplacementString;
	/** The replacement offset. */
	private int fReplacementOffset;
	/** The replacement length. */
	private int fReplacementLength;
	/** The cursor position after this proposal has been applied. */
	private int fCursorPosition;
	/** The image to be displayed in the completion proposal popup. */
	private Image fImage;
	/** The context information of this proposal. */
	private IContextInformation fContextInformation;
	/** The additional info of this proposal. */
	private String fAdditionalProposalInfo;

	/**
	 * Creates a new completion proposal based on the provided information. The replacement string is
	 * considered being the display string too. All remaining fields are set to <code>null</code>.
	 *
	 * @param replacementString the actual string to be inserted into the document
	 * @param replacementOffset the offset of the text to be replaced
	 * @param replacementLength the length of the text to be replaced
	 * @param cursorPosition the position of the cursor following the insert relative to replacementOffset
	 */
	public QvtCompletionProposal(String replacementString, int replacementOffset, int replacementLength, int cursorPosition) {
		this(replacementString, replacementOffset, replacementLength, cursorPosition, null, null, null, null);
	}

	/**
	 * Creates a new completion proposal. All fields are initialized based on the provided information.
	 *
	 * @param replacementString the actual string to be inserted into the document
	 * @param replacementOffset the offset of the text to be replaced
	 * @param replacementLength the length of the text to be replaced
	 * @param cursorPosition the position of the cursor following the insert relative to replacementOffset
	 * @param image the image to display for this proposal
	 * @param displayString the string to be displayed for the proposal
	 * @param contextInformation the context information associated with this proposal
	 * @param additionalProposalInfo the additional information associated with this proposal
	 */
	public QvtCompletionProposal(String replacementString, int replacementOffset, int replacementLength, int cursorPosition, Image image, String displayString, IContextInformation contextInformation, String additionalProposalInfo) {
		Assert.isTrue(replacementOffset >= 0);
		Assert.isTrue(replacementLength >= 0);

		fReplacementString= replacementString;
		fReplacementOffset= replacementOffset;
		fReplacementLength= replacementLength;
		fCursorPosition= cursorPosition;
		fImage= image;
		fDisplayString= displayString;
		fContextInformation= contextInformation;
		fAdditionalProposalInfo= additionalProposalInfo;
	}

	/*
	 * @see ICompletionProposal#apply(IDocument)
	 */
	public void apply(IDocument document) {
		try {
			document.replace(fReplacementOffset, fReplacementLength, fReplacementString);
		} catch (BadLocationException x) {
			// ignore
		}
	}

	/*
	 * @see ICompletionProposal#getSelection(IDocument)
	 */
	public Point getSelection(IDocument document) {
		return new Point(fReplacementOffset + fCursorPosition, 0);
	}

	/*
	 * @see ICompletionProposal#getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		return fContextInformation;
	}

	/*
	 * @see ICompletionProposal#getImage()
	 */
	public Image getImage() {
		return fImage;
	}

	/*
	 * @see ICompletionProposal#getDisplayString()
	 */
	public String getDisplayString() {
		if (fDisplayString != null)
			return fDisplayString;
		return fReplacementString;
	}

	/*
	 * @see ICompletionProposal#getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		return fAdditionalProposalInfo;
	}

	public void setDisplayString(String displayString) {
		fDisplayString = displayString;
	}

	public String getReplacementString() {
		return fReplacementString;
	}

	public void setReplacementString(String replacementString) {
		fReplacementString = replacementString;
	}

	public int getReplacementOffset() {
		return fReplacementOffset;
	}

	public void setReplacementOffset(int replacementOffset) {
		fReplacementOffset = replacementOffset;
	}

	public int getReplacementLength() {
		return fReplacementLength;
	}

	public void setReplacementLength(int replacementLength) {
		fReplacementLength = replacementLength;
	}

	public int getCursorPosition() {
		return fCursorPosition;
	}

	public void setCursorPosition(int cursorPosition) {
		fCursorPosition = cursorPosition;
	}

	public void setImage(Image image) {
		fImage = image;
	}

	public void setContextInformation(IContextInformation contextInformation) {
		fContextInformation = contextInformation;
	}

	public void setAdditionalProposalInfo(String additionalProposalInfo) {
		fAdditionalProposalInfo = additionalProposalInfo;
	}
	

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof QvtCompletionProposal)) {
            return false;
        }
        QvtCompletionProposal proposal = (QvtCompletionProposal) obj;
        if (this == proposal) {
            return true;
        }
        if (fReplacementString == null) {
        	return super.equals(obj);
        }
        return (fReplacementString.equals(proposal.fReplacementString) 
                && fDisplayString.equals(proposal.fDisplayString) 
                && areEqual(fImage, proposal.fImage)
                && areEqual(fAdditionalProposalInfo, proposal.fAdditionalProposalInfo));
    }

    @Override
    public int hashCode() {
        if (fReplacementString == null) {
        	return super.hashCode();
        }
        int[] elementaryHashCodes = {
                fReplacementString.hashCode(),
                fDisplayString.hashCode(),
                hashCodeInternal(fImage),
                hashCodeInternal(fAdditionalProposalInfo)
        };
        int hash = 17;
        for (int i : elementaryHashCodes) {
            hash += 31 * i;
        }
        return hash;
    }
    
    private static boolean areEqual(Object obj1, Object obj2) {
        if (obj1 == null) {
            return obj2 == null;
        }
        return obj1.equals(obj2);
    }
    
    private static int hashCodeInternal(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }	
}
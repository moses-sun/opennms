//
// This file is part of the OpenNMS(R) Application.
//
// OpenNMS(R) is Copyright (C) 2006 The OpenNMS Group, Inc.  All rights reserved.
// OpenNMS(R) is a derivative work, containing both original code, included code and modified
// code that was published under the GNU General Public License. Copyrights for modified
// and included code are below.
//
// OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
//
// Original code base Copyright (C) 1999-2001 Oculan Corp.  All rights reserved.
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
//
// For more information contact:
//      OpenNMS Licensing       <license@opennms.org>
//      http://www.opennms.org/
//      http://www.opennms.com/
//
/*
 * Created on 8-mag-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.opennms.web.map.view;

import org.opennms.web.map.MapsException;

/**
 * @author antonio
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
final public class VLink {
	VElement elem1;
	VElement elem2;
	
	//the link typology defined in the map properties file
	int linkTypeId;

	int linkOperStatus;

	//the link status
	String linkOperStatusString;
	
	public VLink(VElement elem1, VElement elem2) {
		this.elem1 = elem1;
		this.elem2 = elem2;
	}
	
	public String getLinkOperStatusString() {
		if (linkOperStatus == 1 ) return "up";
		else if (linkOperStatus == 2 ) return "down";
		else return "testing";
	}

	/**
	 * Asserts if the links are linking the same elements without considering their statuses
	 */
	public boolean equals(Object otherLink) {
		if (!(otherLink instanceof VLink)) return false;
		VLink link = (VLink) otherLink;
		if (
		 (
		 (this.elem1.hasSameIdentifier(link.getFirst()) && this.elem2.hasSameIdentifier(link.getSecond()))
			||
		 (this.elem2.hasSameIdentifier(link.getFirst()) && this.elem1.hasSameIdentifier(link.getSecond()) ) 
		 )
		 	&&   
		 this.linkTypeId==link.getLinkTypeId()
		) return true;
		return false;
	}
	
	
	public boolean equalsEndPoints(Object otherLink) {
		if (!(otherLink instanceof VLink)) return false;
		VLink link = (VLink) otherLink;
		if (
			 (this.elem1.hasSameIdentifier(link.getFirst()) && this.elem2.hasSameIdentifier(link.getSecond()))
				||
			 (this.elem2.hasSameIdentifier(link.getFirst()) && this.elem1.hasSameIdentifier(link.getSecond()) ) 
			)
		 return true;
		return false;
	}
	
	public int hashCode() {
		return elem1.getId()*elem2.getId()*(linkTypeId+1);
	}

	/*
	 * public boolean hasElement(VElement elem) { if (isFirstElement(elem) ||
	 * isSecondElement(elem)) return true; return false; }
	 * 
	 * private boolean isFirstElement(VElement elem) { if ( elem.getId() ==
	 * elem1.getId() && ( ( elem.isNode() && elem1.isNode() ) || (
	 * elem.isSubmap() && elem1.isSubmap()) )) return true; return false; }
	 * 
	 * private boolean isSecondElement(VElement elem) { if ( elem.getId() ==
	 * elem2.getId() && ( ( elem.isNode() && elem2.isNode() ) || (
	 * elem.isSubmap() && elem2.isSubmap()) )) return true; return false; }
	 */

	public VElement getFirst() {
		return elem1;
	}

	public VElement getSecond() {
		return elem2;
	}
	
	public int getLinkTypeId() {
		return linkTypeId;
	}
	
	public void setLinkTypeId(int typeId) {
		linkTypeId = typeId;
	}

	public int getLinkOperStatus() {
		return linkOperStatus;
	}
	
	public void setLinkOperStatus(int operStatus) {
		linkOperStatus = operStatus;
	}
	
	public String toString() {
			return ""+elem1.getId()+elem1.getType()+"-"+elem2.getId()+elem2.getType()+"-"+linkTypeId+"-"+linkOperStatus+" hashCode:"+this.hashCode();
	}

}

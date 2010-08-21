/*
 * IEMenu.java
 *
 * Created on 24.01.2008, 21:55
 *
 * Copyright (c) 2006-2008, Daniel Apatin (ad), http://apatin.net.ru
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * You can also redistribute and/or modify this program under the
 * terms of the Psi License, specified in the accompanied COPYING
 * file, as published by the Psi Project; either dated January 1st,
 * 2005, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package IE;

//#ifdef IMPORT_EXPORT
//# import Client.StaticData;
//#endif
import io.file.browse.Browser;
import io.file.browse.BrowserListener;
import locale.SR;
import ui.controls.form.DefForm;
import ui.controls.form.LinkString;
import ui.controls.form.SimpleString;
import ui.controls.form.SpacerItem;

/**
 *
 * @author ad
 */
public class IEMenu 
        extends DefForm
        implements BrowserListener {
//#ifdef PLUGINS
//#     public static String plugin = new String("PLUGIN_IE");
//#endif

    private int choice = -1;
    
    public IEMenu() {
        super(
//#if IMPORT_EXPORT
//#         SR.MS_IMPORT_EXPORT
//#else
               ""
//#endif
                 );
        itemsList.addElement(new SimpleString(SR.MS_OPTIONS, true));
        itemsList.addElement(new LinkString(SR.MS_LOAD_FROM_FILE) {
            public void doAction() {
                choice = 0;                
                SelectFile(false);
            }} );
        itemsList.addElement(new LinkString(SR.MS_SAVE_TO_FILE) {
            public void doAction() {
                choice = 1;                
                SelectFile(true);
            }} );            
        itemsList.addElement(new SpacerItem(10));    
        itemsList.addElement(new SimpleString(SR.MS_ACCOUNTS, true));
        itemsList.addElement(new LinkString(SR.MS_LOAD_FROM_FILE) {
            public void doAction() {
                choice = 6;
                SelectFile(false);
            }} );
        itemsList.addElement(new LinkString(SR.MS_SAVE_TO_FILE) {
            public void doAction() {
                choice = 7;
                SelectFile(true);                
            }} );                        
//#ifdef PLUGINS
//#         if (StaticData.getInstance().Archive) {
//#endif           
        itemsList.addElement(new SpacerItem(10));
        itemsList.addElement(new SimpleString(SR.MS_ARCHIVE, true));
        itemsList.addElement(new LinkString(SR.MS_LOAD_FROM_FILE) {
            public void doAction() {
                choice = 2;
                SelectFile(false);
            }} );
        itemsList.addElement(new LinkString(SR.MS_SAVE_TO_FILE) {
            public void doAction() {
                choice = 3;
                SelectFile(true);
            }} );            
        itemsList.addElement(new SpacerItem(10));
        itemsList.addElement(new SimpleString(SR.MS_TEMPLATE, true));
        itemsList.addElement(new LinkString(SR.MS_LOAD_FROM_FILE) {
            public void doAction() {
                choice = 4;                
                SelectFile(false);                
            }} );
        itemsList.addElement(new LinkString(SR.MS_SAVE_TO_FILE) {
            public void doAction() {
                choice = 5;
                SelectFile(true);                
            }} );                        
//#ifdef PLUGINS
//#         }
//#endif
    }
    public void SelectFile(boolean getDir) {
        new Browser(null, this, getDir);
    }
    
    public void BrowserFilePathNotify(String pathSelected) {
        switch (choice) {
            case 0: //load Config
                new IE.ConfigData(pathSelected, 0);
                break;
            case 1: //save Config
                new IE.ConfigData(pathSelected, 1);
                break;
            case 2: //load Archive
                new IE.ArchiveTemplates(0, 1, pathSelected);
                break;
            case 3: //save Archive
                new IE.ArchiveTemplates(1, 1, pathSelected);
                break;
            case 4: //load Templates
                new IE.ArchiveTemplates(0, 0, pathSelected);
                break;
            case 5: //save Templates
                new IE.ArchiveTemplates(1, 0, pathSelected);
                break;
            case 6: //load Accounts
                new IE.Accounts(pathSelected, 0, false);
                break;
            case 7: //save Accounts
                new IE.Accounts(pathSelected, 1, false);
                break;
        }
    }
}

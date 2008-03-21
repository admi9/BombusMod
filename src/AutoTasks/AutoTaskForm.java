/*
 * AutoTaskForm.java
 *
 * Created on 20 ���� 2008 �., 19:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AutoTasks;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import locale.SR;
import ui.controls.NumberField;

/**
 *
 * @author ad
 */
public class AutoTaskForm implements
    CommandListener, ItemCommandListener
{
    private Display display;
    private Displayable parentView;

    Form f;

    private ChoiceGroup taskType;
    private ChoiceGroup actionType;

    private NumberField autoTaskDelay;

    private NumberField autoTaskMin;
    private NumberField autoTaskHour;

    
    /** Creates a new instance of AutoTaskForm */
    public AutoTaskForm(Display display) {
        this.display=display;
        parentView=display.getCurrent();
       
        f=new Form(SR.MS_AUTOTASKS);
        
        taskType=new ChoiceGroup(SR.MS_AUTOTASK_TYPE, Choice.POPUP);
        taskType.append(SR.MS_DISABLED, null);
        taskType.append(SR.MS_BY_TIME_, null);
        taskType.append(SR.MS_BY_TIMER_, null);
        taskType.setSelectedIndex(0, true);
        f.append(taskType);
        
        actionType=new ChoiceGroup(SR.MS_AUTOTASK_ACTION_TYPE, Choice.POPUP);
        actionType.append(SR.MS_QUIT_BOMBUSMOD, null);
        actionType.append(SR.MS_QUIT_CONFERENCES, null);
        actionType.append(SR.MS_LOGOFF, null);
        actionType.setSelectedIndex(0, true);
        f.append(actionType);
        
        autoTaskDelay=new NumberField(SR.MS_AUTOTASK_DELAY, 60, 1, 600);
        f.append(autoTaskDelay);
        
        autoTaskHour=new NumberField(SR.MS_AUTOTASK_TIME+" "+SR.MS_AUTOTASK_HOUR, 0, 0, 23);
        f.append(autoTaskHour);
        autoTaskMin=new NumberField(SR.MS_AUTOTASK_MIN, 0, 0, 59);
        f.append(autoTaskMin);
        
        display.setCurrent(f);
    }

    public void commandAction(Command command, Displayable displayable) {
    }

    public void commandAction(Command command, Item item) {
    }
    
}
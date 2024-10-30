
package com.ing.engine.commands.galenCommands;

import com.ing.engine.core.CommandControl;
import com.ing.engine.galenWrapper.SpecValidation.SpecAttribute;
import com.ing.engine.galenWrapper.SpecValidation.SpecReader;
import com.ing.engine.support.methodInf.Action;
import com.ing.engine.support.methodInf.InputType;
import com.ing.engine.support.methodInf.ObjectType;
import com.galenframework.specs.SpecText;
import java.util.Arrays;

/**
 *
 * 
 */
public class Attribute extends General {

    public Attribute(CommandControl cc) {
        super(cc);
    }

    private void assertElementAttr(SpecText.Type type) {
        SpecAttribute spec = SpecReader.reader().getSpecAttribute(type, Data);
        spec.setOriginalText(getMessage(spec));
        validate(spec, RelativeElement.None);
    }

    private void assertElementAttrI(SpecText.Type type) {
        SpecAttribute spec = SpecReader.reader().getSpecAttribute(type, Data.toLowerCase());
        spec.setOperations(Arrays.asList(new String[]{"lowercase"}));
        spec.setOriginalText(getMessage(spec));
        validate(spec, RelativeElement.None);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute Equals [<Data>]", input =InputType.YES)
    public void assertElementAttrEquals() {
        assertElementAttr(SpecText.Type.IS);
    }

    
    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute Contains [<Data>]", input =InputType.YES)
    public void assertElementAttrContains() {
        assertElementAttr(SpecText.Type.CONTAINS);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute StartsWith [<Data>]", input =InputType.YES)
    public void assertElementAttrStartsWith() {
        assertElementAttr(SpecText.Type.STARTS);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute EndsWith [<Data>]", input =InputType.YES)
    public void assertElementAttrEndsWith() {
        assertElementAttr(SpecText.Type.ENDS);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute Matches [<Data>]", input =InputType.YES)
    public void assertElementAttrMatches() {
        assertElementAttr(SpecText.Type.MATCHES);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute Equals [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIEquals() {
        assertElementAttrI(SpecText.Type.IS);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute Contains [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIContains() {
        assertElementAttrI(SpecText.Type.CONTAINS);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute StartsWith [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIStartsWith() {
        assertElementAttrI(SpecText.Type.STARTS);
    }

    @Action(object = ObjectType.MOBILE, desc ="Assert if [<Object>]'s Attribute EndsWith [Ignorecase] [<Data>]", input =InputType.YES)
    public void assertElementAttrIEndsWith() {
        assertElementAttrI(SpecText.Type.ENDS);
    }

    private String getMessage(SpecAttribute spec) {
        return String.format("%s's Attribute %s %s %s ", ObjectName, spec.getAtributeName(), spec.getType().toString(), spec.getText());
    }

}

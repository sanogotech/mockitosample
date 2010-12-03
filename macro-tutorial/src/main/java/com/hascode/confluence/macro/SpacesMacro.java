package com.hascode.confluence.macro;
 
import java.util.List;
import java.util.Map;
 
import org.apache.log4j.Logger;
 
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.spaces.Space;
import com.atlassian.confluence.spaces.SpaceManager;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import com.atlassian.renderer.RenderContext;
import com.atlassian.renderer.v2.RenderMode;
import com.atlassian.renderer.v2.macro.BaseMacro;
import com.atlassian.renderer.v2.macro.MacroException;
 
public class SpacesMacro extends BaseMacro
        implements
            com.atlassian.renderer.v2.macro.Macro {
 
    public static final String    LOGGER_KEY        = "com.hascode.confluence.macro";
    private static final String    MACRO_TEMPLATE    = "template/macro.vm";
    private static final Logger    log                = Logger.getLogger(LOGGER_KEY);
 
    private SpaceManager        spaceManager;
 
    /*
     * (non-Javadoc)
     *
     * @see com.atlassian.renderer.v2.macro.Macro#execute(java.util.Map,
     * java.lang.String, com.atlassian.renderer.RenderContext)
     */
    public String execute(Map params, String body, RenderContext renderContext)
            throws MacroException {
        log.debug("macro execution triggered with params " + params.toString());
        Map ctx = MacroUtils.defaultVelocityContext();
        ctx.put("spaces", this.findSpaces());
        return VelocityUtils.getRenderedTemplate(MACRO_TEMPLATE, ctx);
    }
    /*
     * (non-Javadoc)
     *
     * @see com.atlassian.renderer.v2.macro.Macro#getBodyRenderMode()
     */
    public RenderMode getBodyRenderMode() {
        return RenderMode.ALL;
    }
 
    /*
     * (non-Javadoc)
     *
     * @see com.atlassian.renderer.v2.macro.Macro#hasBody()
     */
    public boolean hasBody() {
        return false;
    }
 
    /*
     * (non-Javadoc)
     *
     * @see com.atlassian.renderer.v2.macro.Macro#isInline()
     */
    public boolean isInline() {
        return false;
    }
 
    /*
     * (non-Javadoc)
     *
     * @see
     * com.atlassian.renderer.v2.macro.Macro#suppressMacroRenderingDuringWysiwyg
     * ()
     */
    public boolean suppressMacroRenderingDuringWysiwyg() {
        return false;
    }
 
    /*
     * (non-Javadoc)
     *
     * @seecom.atlassian.renderer.v2.macro.Macro#
     * suppressSurroundingTagDuringWysiwygRendering()
     */
    public boolean suppressSurroundingTagDuringWysiwygRendering() {
        return false;
    }
 
    @SuppressWarnings("unchecked")
    private List findSpaces() {
        return spaceManager.getAllSpaces();
    }
 
    /**
     * set by IoC container
     *
     * @param spaceManager
     *            the space manager
     */
    public void setSpaceManager(SpaceManager spaceManager) {
        this.spaceManager = spaceManager;
    }
}

package com.bolyartech.forge.server.tple.thymeleaf;

import com.bolyartech.forge.server.misc.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;


public class ThymeleafTemplateEngine implements TemplateEngine {
    private final Map<String, Object> mAttributes = new HashMap<>();
    private final org.thymeleaf.TemplateEngine mTemplateEngine;


    public ThymeleafTemplateEngine(org.thymeleaf.TemplateEngine templateEngine) {
        mTemplateEngine = templateEngine;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        Context context = new Context();
        context.setVariables(mAttributes);

        return mTemplateEngine.process(templateName, context);
    }
}

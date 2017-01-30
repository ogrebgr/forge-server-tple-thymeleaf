package com.bolyartech.forge.server.tple.thymeleaf;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


public class ThymeleafTemplateEngineFactory implements TemplateEngineFactory {
    private final org.thymeleaf.TemplateEngine mTemplateEngine;


    public ThymeleafTemplateEngineFactory(org.thymeleaf.TemplateEngine templateEngine) {
        mTemplateEngine = templateEngine;
    }


    public ThymeleafTemplateEngineFactory(String mTemplatePathPrefix) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix(mTemplatePathPrefix);

        mTemplateEngine = new org.thymeleaf.TemplateEngine();
        mTemplateEngine.setTemplateResolver(templateResolver);
    }


    @Override
    public TemplateEngine createNew() {
        return new ThymeleafTemplateEngine(mTemplateEngine);
    }
}

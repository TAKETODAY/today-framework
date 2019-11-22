/**
 * Original Author -> 杨海健 (taketoday@foxmail.com) https://taketoday.cn
 * Copyright © TODAY & 2017 - 2019 All Rights Reserved.
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *   
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/]
 */
package cn.taketoday.framework.reactive;

import java.util.Map;
import java.util.Properties;

import cn.taketoday.context.annotation.Autowired;
import cn.taketoday.context.factory.InitializingBean;
import cn.taketoday.web.RequestContext;
import cn.taketoday.web.config.WebMvcConfiguration;
import cn.taketoday.web.view.AbstractFreeMarkerViewResolver;
import cn.taketoday.web.view.RequestContextParametersHashModel;
import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.template.Configuration;
import freemarker.template.DefaultMapAdapter;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.utility.ObjectWrapperWithAPISupport;

/**
 * @author TODAY <br>
 *         2019-11-22 13:25
 */
public class ReactiveFreeMarkerViewResolver
        extends AbstractFreeMarkerViewResolver implements InitializingBean, WebMvcConfiguration {

    @Autowired
    public ReactiveFreeMarkerViewResolver(ObjectWrapper wrapper, Configuration configuration, Properties settings) {
        super(wrapper, configuration, settings);
    }

    /**
     * Create Model Attributes.
     * 
     * @param context
     *            Current request context
     * @return {@link TemplateHashModel}
     */
    protected TemplateHashModel createModel(RequestContext context) {
        final ObjectWrapper wrapper = this.getWrapper();

        final Map<String, Object> attributes = context.asMap();

        // Create hash model wrapper for request
        attributes.put(FreemarkerServlet.KEY_REQUEST_PARAMETERS, new RequestContextParametersHashModel(context));

        return DefaultMapAdapter.adapt(attributes, (ObjectWrapperWithAPISupport) wrapper);
    }

}

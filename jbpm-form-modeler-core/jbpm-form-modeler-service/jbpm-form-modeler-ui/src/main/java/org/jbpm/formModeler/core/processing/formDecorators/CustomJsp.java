/**
 * Copyright (C) 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.formModeler.core.processing.formDecorators;

import org.jbpm.formModeler.service.annotation.config.Config;
import org.jbpm.formModeler.service.bb.mvc.controller.RequestContext;
import org.jbpm.formModeler.api.model.Field;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Custom JSP decorator
 */
@ApplicationScoped
public class CustomJsp extends FormDecorator {

    @Inject @Config("/formModeler/formDecorators/customJsp/input.jsp")
    private String pageToIncludeForRendering;

    @Inject @Config("/formModeler/formDecorators/customJsp/show.jsp")
    private String pageToIncludeForDisplaying;

    @Inject @Config("/formModeler/formDecorators/customJsp/search.jsp")
    private String pageToIncludeForSearching;

    public String getPageToIncludeForRendering() {
        return pageToIncludeForRendering;
    }

    public void setPageToIncludeForRendering(String pageToIncludeForRendering) {
        this.pageToIncludeForRendering = pageToIncludeForRendering;
    }

    public String getPageToIncludeForDisplaying() {
        return pageToIncludeForDisplaying;
    }

    public void setPageToIncludeForDisplaying(String pageToIncludeForDisplaying) {
        this.pageToIncludeForDisplaying = pageToIncludeForDisplaying;
    }

    public String getPageToIncludeForSearching() {
        return pageToIncludeForSearching;
    }

    public void setPageToIncludeForSearching(String pageToIncludeForSearching) {
        this.pageToIncludeForSearching = pageToIncludeForSearching;
    }

    public void initialize(Field field, String namespace) {
        super.initialize(field, namespace);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getRequest().getRequestObject().setAttribute(field.getForm().getId() + "." + field.getFieldName() + ".reset." + namespace, Boolean.TRUE);
    }
}

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
package org.jbpm.formModeler.components.editor;

import org.jbpm.formModeler.service.LocaleManager;
import org.jbpm.formModeler.service.bb.mvc.taglib.formatter.Formatter;
import org.jbpm.formModeler.service.bb.mvc.taglib.formatter.FormatterException;
import org.jbpm.formModeler.api.model.Field;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Named("FieldPropertyTooltipFormatter")
public class FieldPropertyTooltipFormatter extends Formatter {

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws FormatterException {
        Field field = (Field) getParameter("field");
        Map fieldTitle = field.getTitle();
        if (fieldTitle != null) {
            String help = (String) LocaleManager.lookup().localize(fieldTitle);
            if (help != null && !"".equals(help.trim())) {
                setAttribute("help", help);
                renderFragment("output");
            }
        }
    }
}

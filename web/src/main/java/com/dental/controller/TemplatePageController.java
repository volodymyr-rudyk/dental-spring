package com.dental.controller;

import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vrudyk on 5/14/2016.
 */
@Controller
public class TemplatePageController extends AbstractBasePageController {

  private static final String VIEW_FOLDER = "template";

  @RequestMapping("/template/{folder}/{name}")
  public String template(HttpServletRequest servletRequest, @PathVariable("folder") String folder,
                         @PathVariable("name") String templateName) {
    if (StringUtils.isEmpty(folder) || StringUtils.isEmpty(templateName)) {
      throw new NotFoundException("empty path or template");
    }
    return renderView(folder, templateName);
  }

  protected String renderView(String folder, String view) {
    final String viewPath = folder + "/" + view;
    return super.renderView(viewPath);
  }

  @Override
  protected String getViewFolder() {
    return VIEW_FOLDER;
  }
}

/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.photon.bootstrap3.breadcrumbs;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.html.hc.ext.HCA_JS;
import com.helger.html.hc.html.grouping.AbstractHCOL;
import com.helger.html.hc.html.textlevel.HCA;
import com.helger.html.js.IHasJSCode;
import com.helger.photon.bootstrap3.CBootstrapCSS;
import com.helger.url.ISimpleURL;

/**
 * Breadcrumbs
 *
 * @author Philip Helger
 */
public class BootstrapBreadcrumbs extends AbstractHCOL <BootstrapBreadcrumbs>
{
  public BootstrapBreadcrumbs ()
  {
    addClass (CBootstrapCSS.BREADCRUMB);
  }

  @NonNull
  public BootstrapBreadcrumbs addLink (@NonNull final ISimpleURL aURL, @NonNull final String sText)
  {
    addItem (new HCA (aURL).addChild (sText));
    return this;
  }

  @NonNull
  public BootstrapBreadcrumbs addLink (@NonNull final IHasJSCode aJSCodeProvider, @NonNull final String sText)
  {
    addItem (new HCA_JS (aJSCodeProvider).addChild (sText));
    return this;
  }

  @NonNull
  public BootstrapBreadcrumbs addActive (@Nullable final String sText)
  {
    addAndReturnItem (sText).addClass (CBootstrapCSS.ACTIVE);
    return this;
  }
}

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
package com.helger.photon.bootstrap3.pages;

import com.helger.annotation.Nonempty;
import com.helger.annotation.concurrent.NotThreadSafe;
import com.helger.annotation.style.OverrideOnDemand;
import com.helger.base.id.IHasID;
import com.helger.html.hc.IHCNode;
import com.helger.photon.bootstrap3.button.BootstrapButtonToolbar;
import com.helger.photon.bootstrap3.form.BootstrapForm;
import com.helger.photon.uicore.page.AbstractWebPageForm;
import com.helger.photon.uicore.page.IWebPageExecutionContext;
import com.helger.text.IMultilingualText;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Abstract base class for a Bootstrap based web page that has the common form
 * handling, with a list view, details view, create and edit + binding.
 *
 * @author Philip Helger
 * @param <DATATYPE>
 *        The data type of the object to be handled.
 * @param <WPECTYPE>
 *        Web page execution context type
 */
@NotThreadSafe
public abstract class AbstractBootstrapWebPageForm <DATATYPE extends IHasID <String>, WPECTYPE extends IWebPageExecutionContext> extends
                                                   AbstractWebPageForm <DATATYPE, WPECTYPE, BootstrapForm, BootstrapButtonToolbar>
{
  public AbstractBootstrapWebPageForm (@Nonnull @Nonempty final String sID, @Nonnull final String sName)
  {
    super (sID, getAsMLT (sName), null, BootstrapWebPageUIHandler.INSTANCE);
  }

  public AbstractBootstrapWebPageForm (@Nonnull @Nonempty final String sID, @Nonnull final IMultilingualText aName)
  {
    super (sID, aName, null, BootstrapWebPageUIHandler.INSTANCE);
  }

  public AbstractBootstrapWebPageForm (@Nonnull @Nonempty final String sID,
                                       @Nonnull final String sName,
                                       @Nullable final String sDescription)
  {
    super (sID, getAsMLT (sName), getAsMLT (sDescription), BootstrapWebPageUIHandler.INSTANCE);
  }

  public AbstractBootstrapWebPageForm (@Nonnull @Nonempty final String sID,
                                       @Nonnull final IMultilingualText aName,
                                       @Nullable final IMultilingualText aDescription)
  {
    super (sID, aName, aDescription, BootstrapWebPageUIHandler.INSTANCE);
  }

  @Override
  @Nullable
  @OverrideOnDemand
  public IHCNode getHeaderNode (@Nonnull final WPECTYPE aWPEC)
  {
    final String sHeaderText = getHeaderText (aWPEC);
    return getUIHandler ().createPageHeader (sHeaderText);
  }
}

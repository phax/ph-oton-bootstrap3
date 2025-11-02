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
package com.helger.photon.bootstrap3.pagination;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.base.string.StringHelper;
import com.helger.html.hc.IHCNode;
import com.helger.html.hc.html.grouping.AbstractHCUL;
import com.helger.html.hc.html.textlevel.HCSpan;
import com.helger.photon.bootstrap3.CBootstrapCSS;

public class BootstrapPagination extends AbstractHCUL <BootstrapPagination>
{
  public BootstrapPagination ()
  {
    this (EBootstrapPaginationType.DEFAULT);
  }

  public BootstrapPagination (@NonNull final EBootstrapPaginationType eType)
  {
    addClasses (CBootstrapCSS.PAGINATION, eType);
  }

  @NonNull
  public BootstrapPagination addItemActive (@Nullable final String sContent)
  {
    if (StringHelper.isNotEmpty (sContent))
      addItemActive (new HCSpan ().addChild (sContent));
    return this;
  }

  @NonNull
  public BootstrapPagination addItemActive (@Nullable final IHCNode aContent)
  {
    addAndReturnItem (aContent).addClass (CBootstrapCSS.ACTIVE);
    return this;
  }

  @NonNull
  public BootstrapPagination addItemDisabled (@Nullable final String sContent)
  {
    if (StringHelper.isNotEmpty (sContent))
      addItemDisabled (new HCSpan ().addChild (sContent));
    return this;
  }

  @NonNull
  public BootstrapPagination addItemDisabled (@Nullable final IHCNode aContent)
  {
    addAndReturnItem (aContent).addClass (CBootstrapCSS.DISABLED);
    return this;
  }
}

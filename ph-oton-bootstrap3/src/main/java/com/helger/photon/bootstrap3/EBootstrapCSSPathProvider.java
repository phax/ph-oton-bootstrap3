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
package com.helger.photon.bootstrap3;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.css.media.ICSSMediaList;
import com.helger.html.resource.css.ConstantCSSPathProvider;
import com.helger.html.resource.css.ICSSPathProvider;

/**
 * Contains default CSS paths within this library.
 *
 * @author Philip Helger
 */
public enum EBootstrapCSSPathProvider implements ICSSPathProvider
{
  /** Main Bootstrap CSS */
  BOOTSTRAP ("external/bootstrap/3.4.1/css/bootstrap.css"),
  /** Bootstrap theme CSS */
  BOOTSTRAP_THEME ("external/bootstrap/3.4.1/css/bootstrap-theme.css"),
  /** A some of default Bootstrap CSS adoptions etc. */
  BOOTSTRAP_PH ("ph-oton/bootstrap3-ph.css");

  private final ConstantCSSPathProvider m_aPP;

  EBootstrapCSSPathProvider (@Nonnull @Nonempty final String sPath)
  {
    m_aPP = ConstantCSSPathProvider.builder ().path (sPath).minifiedPathFromPath ().build ();
  }

  EBootstrapCSSPathProvider (@Nonnull @Nonempty final String sPath, @Nullable final String sConditionalComment)
  {
    m_aPP = ConstantCSSPathProvider.builder ()
                                   .path (sPath)
                                   .minifiedPathFromPath ()
                                   .conditionalComment (sConditionalComment)
                                   .build ();
  }

  @Nonnull
  @Nonempty
  public String getCSSItemPath (final boolean bRegular)
  {
    return m_aPP.getCSSItemPath (bRegular);
  }

  @Nullable
  public String getConditionalComment ()
  {
    return m_aPP.getConditionalComment ();
  }

  @Nonnull
  @ReturnsMutableCopy
  public ICSSMediaList getMediaList ()
  {
    return m_aPP.getMediaList ();
  }

  public boolean isBundlable ()
  {
    return m_aPP.isBundlable ();
  }
}

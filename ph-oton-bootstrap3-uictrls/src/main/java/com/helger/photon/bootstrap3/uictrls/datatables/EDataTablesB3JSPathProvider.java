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
package com.helger.photon.bootstrap3.uictrls.datatables;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.string.StringHelper;
import com.helger.html.resource.js.ConstantJSPathProvider;
import com.helger.html.resource.js.IJSPathProvider;
import com.helger.photon.uictrls.datatables.CDataTablesComponentVersion;

/**
 * Contains default JS paths for this project.
 *
 * @author Philip Helger
 */
public enum EDataTablesB3JSPathProvider implements IJSPathProvider
{
  DATATABLES_BOOTSTRAP3 ("external/datatables/datatables-" +
                         CDataTablesComponentVersion.DT +
                         "/js/dataTables.bootstrap.js"),
  DATATABLES_AUTO_FILL_BOOTSTRAP3 ("external/datatables/autofill-" +
                                   CDataTablesComponentVersion.AUTO_FILL +
                                   "/js/autoFill.bootstrap.js"),
  DATATABLES_BUTTONS_BOOTSTRAP3 ("external/datatables/buttons-" +
                                 CDataTablesComponentVersion.BUTTONS +
                                 "/js/buttons.bootstrap.js"),
  DATATABLES_RESPONSIVE_BOOTSTRAP3 ("external/datatables/responsive-" +
                                    CDataTablesComponentVersion.RESPONSIVE +
                                    "/js/responsive.bootstrap.js"),
  DATATABLES_SEARCH_BUILDER_BOOTSTRAP3 ("external/datatables/searchbuilder-" +
                                        CDataTablesComponentVersion.SEARCH_BUILDER +
                                        "/js/searchBuilder.bootstrap.js"),
  DATATABLES_SEARCH_PANES_BOOTSTRAP3 ("external/datatables/searchpanes-" +
                                      CDataTablesComponentVersion.SEARCH_PANES +
                                      "/js/searchPanes.bootstrap.js"),
  DATATABLES_STATE_RESTORE_BOOTSTRAP3 ("external/datatables/staterestore-" +
                                       CDataTablesComponentVersion.STATE_RESTORE +
                                       "/js/stateRestore.bootstrap.js");

  private final ConstantJSPathProvider m_aPP;

  EDataTablesB3JSPathProvider (@Nonnull @Nonempty final String sPath)
  {
    m_aPP = ConstantJSPathProvider.create (sPath);
  }

  @Nonnull
  @Nonempty
  public String getJSItemPath (final boolean bRegular)
  {
    return m_aPP.getJSItemPath (bRegular);
  }

  @Nullable
  public String getConditionalComment ()
  {
    return m_aPP.getConditionalComment ();
  }

  public boolean isBundlable ()
  {
    return m_aPP.isBundlable ();
  }

  @Nonnull
  public IJSPathProvider getInstance (@Nonnull @Nonempty final String sLanguage)
  {
    return ConstantJSPathProvider.createWithConditionalComment (StringHelper.replaceAll (m_aPP.getJSItemPathRegular (),
                                                                                         "{0}",
                                                                                         sLanguage),
                                                                m_aPP.getConditionalComment ());
  }
}

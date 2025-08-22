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

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.css.media.ICSSMediaList;
import com.helger.html.resource.css.ConstantCSSPathProvider;
import com.helger.html.resource.css.ICSSPathProvider;
import com.helger.photon.uictrls.datatables.CDataTablesComponentVersion;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Contains default CSS paths for this project.
 *
 * @author Philip Helger
 */
public enum EDataTablesB3CSSPathProvider implements ICSSPathProvider
{
  DATATABLES_BOOTSTRAP3 ("external/datatables/datatables-" +
                         CDataTablesComponentVersion.DT +
                         "/css/dataTables.bootstrap.css"),
  DATATABLES_AUTO_FILL_BOOTSTRAP3 ("external/datatables/autofill-" +
                                   CDataTablesComponentVersion.AUTO_FILL +
                                   "/css/autoFill.bootstrap.css"),
  DATATABLES_BUTTONS_BOOTSTRAP3 ("external/datatables/buttons-" +
                                 CDataTablesComponentVersion.BUTTONS +
                                 "/css/buttons.bootstrap.css"),
  DATATABLES_COL_REORDER_BOOTSTRAP3 ("external/datatables/colreorder-" +
                                     CDataTablesComponentVersion.COL_REORDER +
                                     "/css/colReorder.bootstrap.css"),
  DATATABLES_FIXED_COLUMNS_BOOTSTRAP3 ("external/datatables/fixedcolumns-" +
                                       CDataTablesComponentVersion.FIXED_COLUMNS +
                                       "/css/fixedColumns.bootstrap.css"),
  DATATABLES_FIXED_HEADER_BOOTSTRAP3 ("external/datatables/fixedheader-" +
                                      CDataTablesComponentVersion.FIXED_HEADER +
                                      "/css/fixedHeader.bootstrap.css"),
  DATATABLES_KEY_TABLE_BOOTSTRAP3 ("external/datatables/keytable-" +
                                   CDataTablesComponentVersion.KEY_TABLE +
                                   "/css/keyTable.bootstrap.css"),
  DATATABLES_RESPONSIVE_BOOTSTRAP3 ("external/datatables/responsive-" +
                                    CDataTablesComponentVersion.RESPONSIVE +
                                    "/css/responsive.bootstrap.css"),
  DATATABLES_ROW_GROUP_BOOTSTRAP3 ("external/datatables/rowgroup-" +
                                   CDataTablesComponentVersion.ROW_GROUP +
                                   "/css/rowGroup.bootstrap.css"),
  DATATABLES_ROW_REORDER_BOOTSTRAP3 ("external/datatables/rowreorder-" +
                                     CDataTablesComponentVersion.ROW_REORDER +
                                     "/css/rowReorder.bootstrap.css"),
  DATATABLES_SCROLLER_BOOTSTRAP3 ("external/datatables/scroller-" +
                                  CDataTablesComponentVersion.SCROLLER +
                                  "/css/scroller.bootstrap.css"),
  DATATABLES_SELECT_BOOTSTRAP3 ("external/datatables/select-" +
                                CDataTablesComponentVersion.SELECT +
                                "/css/select.bootstrap.css"),

  BOOTSTRAP3_DATATABLES_PH ("ph-oton/bootstrap3-datatables-ph.css");

  private final ConstantCSSPathProvider m_aPP;

  EDataTablesB3CSSPathProvider (@Nonnull @Nonempty final String sPath)
  {
    m_aPP = ConstantCSSPathProvider.builder ().path (sPath).minifiedPathFromPath ().build ();
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

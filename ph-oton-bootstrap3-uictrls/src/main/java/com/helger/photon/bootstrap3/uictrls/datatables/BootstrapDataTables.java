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

import com.helger.html.annotation.OutOfBandNode;
import com.helger.html.hc.IHCConversionSettingsToNode;
import com.helger.html.hc.html.tabular.IHCTable;
import com.helger.photon.app.html.PhotonCSS;
import com.helger.photon.app.html.PhotonJS;
import com.helger.photon.bootstrap3.CBootstrapCSS;
import com.helger.photon.core.execcontext.ILayoutExecutionContext;
import com.helger.photon.uictrls.datatables.DataTables;
import com.helger.photon.uictrls.datatables.EDataTablesCSSPathProvider;

@OutOfBandNode
public class BootstrapDataTables extends DataTables
{
  private static IBootstrapDataTablesConfigurator s_aConfigurator;

  public BootstrapDataTables (@Nonnull final IHCTable <?> aTable)
  {
    super (aTable);
    setDom (new BootstrapDataTablesDom ());
  }

  @Override
  protected void onRegisterExternalResources (@Nonnull final IHCConversionSettingsToNode aConversionSettings,
                                              final boolean bForceRegistration)
  {
    super.onRegisterExternalResources (aConversionSettings, bForceRegistration);
    PhotonJS.registerJSIncludeForThisRequest (EDataTablesB3JSPathProvider.DATATABLES_BOOTSTRAP3);
    // Original CSS not needed, when Bootstrap is used
    PhotonCSS.unregisterCSSIncludeFromThisRequest (EDataTablesCSSPathProvider.DATATABLES);
    PhotonCSS.registerCSSIncludeForThisRequest (EDataTablesB3CSSPathProvider.DATATABLES_BOOTSTRAP3);
    PhotonCSS.registerCSSIncludeForThisRequest (EDataTablesB3CSSPathProvider.BOOTSTRAP3_DATATABLES_PH);
  }

  @Nullable
  public static IBootstrapDataTablesConfigurator getConfigurator ()
  {
    return s_aConfigurator;
  }

  public static void setConfigurator (@Nullable final IBootstrapDataTablesConfigurator aConfigurator)
  {
    s_aConfigurator = aConfigurator;
  }

  @Nonnull
  public static BootstrapDataTables createDefaultDataTables (@Nonnull final ILayoutExecutionContext aLEC,
                                                             @Nonnull final IHCTable <?> aTable)
  {
    // Assign special table class for Bootstrap look and feel
    aTable.addClass (CBootstrapCSS.TABLE).addClass (CBootstrapCSS.TABLE_STRIPED);

    final BootstrapDataTables ret = new BootstrapDataTables (aTable);
    ret.setDisplayLocale (aLEC.getDisplayLocale ());
    ret.addAllColumns (aTable);
    if (s_aConfigurator != null)
      s_aConfigurator.configure (aLEC, aTable, ret);
    return ret;
  }
}

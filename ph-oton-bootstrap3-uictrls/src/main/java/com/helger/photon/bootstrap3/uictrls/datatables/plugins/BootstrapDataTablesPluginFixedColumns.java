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
package com.helger.photon.bootstrap3.uictrls.datatables.plugins;

import com.helger.html.hc.IHCConversionSettingsToNode;
import com.helger.photon.app.html.PhotonCSS;
import com.helger.photon.bootstrap3.uictrls.datatables.EDataTablesB3CSSPathProvider;
import com.helger.photon.uictrls.datatables.EDataTablesCSSPathProvider;
import com.helger.photon.uictrls.datatables.plugins.DataTablesPluginFixedColumns;

public class BootstrapDataTablesPluginFixedColumns extends DataTablesPluginFixedColumns
{
  @Override
  public void registerExternalResources (final IHCConversionSettingsToNode aConversionSettings)
  {
    super.registerExternalResources (aConversionSettings);
    // Change CSS
    PhotonCSS.unregisterCSSIncludeFromThisRequest (EDataTablesCSSPathProvider.DATATABLES_FIXED_COLUMNS);
    PhotonCSS.registerCSSIncludeForThisRequest (EDataTablesB3CSSPathProvider.DATATABLES_FIXED_COLUMNS_BOOTSTRAP3);
  }
}

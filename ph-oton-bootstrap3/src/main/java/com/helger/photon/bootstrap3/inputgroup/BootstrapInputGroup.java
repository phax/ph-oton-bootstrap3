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
package com.helger.photon.bootstrap3.inputgroup;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.style.ReturnsMutableObject;
import com.helger.base.enforce.ValueEnforcer;
import com.helger.html.hc.IHCConversionSettingsToNode;
import com.helger.html.hc.IHCHasChildrenMutable;
import com.helger.html.hc.IHCNode;
import com.helger.html.hc.html.grouping.AbstractHCDiv;
import com.helger.html.hc.html.textlevel.HCSpan;
import com.helger.html.hc.impl.HCNodeList;
import com.helger.photon.bootstrap3.CBootstrapCSS;
import com.helger.photon.bootstrap3.button.BootstrapButton;

public class BootstrapInputGroup extends AbstractHCDiv <BootstrapInputGroup>
{
  private final EBootstrapInputGroupSize m_eSize;
  private final HCNodeList m_aPrefixes = new HCNodeList ();
  private final IHCNode m_aInput;
  private final HCNodeList m_aSuffixes = new HCNodeList ();

  public BootstrapInputGroup (@NonNull final IHCNode aInput)
  {
    this (EBootstrapInputGroupSize.DEFAULT, aInput);
  }

  public BootstrapInputGroup (@NonNull final EBootstrapInputGroupSize eSize, @NonNull final IHCNode aInput)
  {
    m_eSize = ValueEnforcer.notNull (eSize, "Size");
    m_aInput = ValueEnforcer.notNull (aInput, "Input");
  }

  @NonNull
  public final EBootstrapInputGroupSize getSize ()
  {
    return m_eSize;
  }

  @NonNull
  @ReturnsMutableObject
  public final HCNodeList prefixes ()
  {
    return m_aPrefixes;
  }

  @NonNull
  public BootstrapInputGroup setPrefix (@Nullable final String sText)
  {
    m_aPrefixes.setChild (sText);
    return this;
  }

  @NonNull
  public BootstrapInputGroup setPrefix (@Nullable final IHCNode aNode)
  {
    m_aPrefixes.setChild (aNode);
    return this;
  }

  @NonNull
  public final IHCNode getInput ()
  {
    return m_aInput;
  }

  @NonNull
  @ReturnsMutableObject
  public final HCNodeList suffixes ()
  {
    return m_aSuffixes;
  }

  @NonNull
  public BootstrapInputGroup setSuffix (@Nullable final String sText)
  {
    m_aSuffixes.setChild (sText);
    return this;
  }

  @NonNull
  public BootstrapInputGroup setSuffix (@Nullable final IHCNode aNode)
  {
    m_aSuffixes.setChild (aNode);
    return this;
  }

  public boolean hasNeitherPrefixNorSuffix ()
  {
    return m_aPrefixes.hasNoChildren () && m_aSuffixes.hasNoChildren ();
  }

  @Override
  protected void onFinalizeNodeState (@NonNull final IHCConversionSettingsToNode aConversionSettings,
                                      @NonNull final IHCHasChildrenMutable <?, ? super IHCNode> aTargetNode)
  {
    super.onFinalizeNodeState (aConversionSettings, aTargetNode);
    addClasses (CBootstrapCSS.INPUT_GROUP, m_eSize);

    if (m_aPrefixes.hasChildren ())
      for (final IHCNode aPrefix : m_aPrefixes.getChildren ())
      {
        if (aPrefix instanceof BootstrapButton)
          addChild (new HCSpan ().addClass (CBootstrapCSS.INPUT_GROUP_BTN).addChild (aPrefix));
        else
          addChild (new HCSpan ().addClass (CBootstrapCSS.INPUT_GROUP_ADDON).addChild (aPrefix));
      }

    addChild (m_aInput);

    if (m_aSuffixes.hasChildren ())
      for (final IHCNode aSuffix : m_aSuffixes.getChildren ())
      {
        if (aSuffix instanceof BootstrapButton)
          addChild (new HCSpan ().addClass (CBootstrapCSS.INPUT_GROUP_BTN).addChild (aSuffix));
        else
          addChild (new HCSpan ().addClass (CBootstrapCSS.INPUT_GROUP_ADDON).addChild (aSuffix));
      }
  }
}

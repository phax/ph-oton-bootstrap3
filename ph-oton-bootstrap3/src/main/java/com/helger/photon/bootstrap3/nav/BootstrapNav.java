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
package com.helger.photon.bootstrap3.nav;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.misc.Since;
import com.helger.base.enforce.ValueEnforcer;
import com.helger.base.string.StringHelper;
import com.helger.html.hc.IHCNode;
import com.helger.html.hc.html.IHCElementWithChildren;
import com.helger.html.hc.html.forms.IHCButton;
import com.helger.html.hc.html.grouping.AbstractHCUL;
import com.helger.html.hc.html.grouping.IHCLI;
import com.helger.html.hc.html.textlevel.HCA;
import com.helger.html.hc.html.textlevel.HCSpan;
import com.helger.html.hc.impl.HCTextNode;
import com.helger.photon.bootstrap3.CBootstrapCSS;
import com.helger.photon.bootstrap3.dropdown.BootstrapDropdown;
import com.helger.photon.bootstrap3.dropdown.BootstrapDropdownMenu;
import com.helger.photon.bootstrap3.dropdown.EBootstrapDropdownMenuAlignment;
import com.helger.photon.uicore.icon.IIcon;
import com.helger.url.ISimpleURL;
import com.helger.url.SimpleURL;

/**
 * Navigation items
 *
 * @author Philip Helger
 */
public class BootstrapNav extends AbstractHCUL <BootstrapNav>
{
  /** By default an item is not disabled */
  public static final boolean DEFAULT_DISABLED = false;

  private final EBootstrapNavType m_eNavType;

  public BootstrapNav ()
  {
    this (EBootstrapNavType.DEFAULT);
  }

  public BootstrapNav (@NonNull final EBootstrapNavType eNavType)
  {
    ValueEnforcer.notNull (eNavType, "NavType");

    addClass (CBootstrapCSS.NAV);
    addClasses (eNavType.getAllCSSClasses ());
    m_eNavType = eNavType;
  }

  @NonNull
  public EBootstrapNavType getNavType ()
  {
    return m_eNavType;
  }

  @NonNull
  public BootstrapNav addItem (@Nullable final String sText, @NonNull final ISimpleURL aTarget)
  {
    return addItem (sText, aTarget, DEFAULT_DISABLED, (IIcon) null);
  }

  @NonNull
  public BootstrapNav addItem (@Nullable final String sText, @NonNull final ISimpleURL aTarget, @Nullable final IIcon aIcon)
  {
    return addItem (sText, aTarget, DEFAULT_DISABLED, aIcon);
  }

  @NonNull
  public BootstrapNav addItem (@Nullable final String sText, @NonNull final ISimpleURL aTarget, final boolean bDisabled)
  {
    // no icon
    return addItem (sText, aTarget, bDisabled, null);
  }

  @NonNull
  public BootstrapNav addItem (@Nullable final String sText,
                               @NonNull final ISimpleURL aTarget,
                               final boolean bDisabled,
                               @Nullable final IIcon aIcon)
  {
    return addItem (new HCA (aTarget).addChild (sText), bDisabled, aIcon);
  }

  @NonNull
  public BootstrapNav addItem (@Nullable final IHCElementWithChildren <?> aContent)
  {
    return addItem (aContent, DEFAULT_DISABLED);
  }

  @NonNull
  public BootstrapNav addItem (@Nullable final IHCElementWithChildren <?> aContent, final boolean bDisabled)
  {
    return addItem (aContent, bDisabled, null);
  }

  @NonNull
  public BootstrapNav addItem (@Nullable final IHCElementWithChildren <?> aContent, final boolean bDisabled, @Nullable final IIcon aIcon)
  {
    final IHCLI <?> aItem = addAndReturnItem (aContent);
    if (bDisabled)
      aItem.addClass (CBootstrapCSS.DISABLED);
    if (aIcon != null)
    {
      // Icon is the first child of the content
      aContent.addChildAt (0, aIcon.getAsNode ());
    }
    return this;
  }

  @NonNull
  @Since ("7.10")
  public BootstrapNav addText (@Nullable final String sText)
  {
    return addText (new HCSpan ().addChild (sText));
  }

  @NonNull
  @Since ("7.10")
  public BootstrapNav addText (@NonNull final IHCElementWithChildren <?> aContent)
  {
    return addItem (aContent.addClass (CBootstrapCSS.NAVBAR_TEXT), DEFAULT_DISABLED);
  }

  @NonNull
  @Since ("7.10")
  public BootstrapNav addButton (@NonNull final IHCButton <?> aButton)
  {
    return addButton (aButton, DEFAULT_DISABLED);
  }

  @NonNull
  @Since ("7.10")
  public BootstrapNav addButton (@NonNull final IHCButton <?> aButton, final boolean bDisabled)
  {
    aButton.addClass (CBootstrapCSS.NAVBAR_BTN);
    addItem (aButton, bDisabled, null);
    return this;
  }

  @NonNull
  public BootstrapNav addDivider ()
  {
    addItem ().addClass (CBootstrapCSS.DIVIDER);
    return this;
  }

  @NonNull
  public BootstrapNav addHeader (@Nullable final String sHeaderText)
  {
    if (StringHelper.isNotEmpty (sHeaderText))
      addItem (sHeaderText).addClass (CBootstrapCSS.DROPDOWN_HEADER);
    return this;
  }

  @NonNull
  public BootstrapDropdownMenu addDropdownMenu (@Nullable final String sText)
  {
    return addDropdownMenu (EBootstrapDropdownMenuAlignment.DEFAULT, new HCTextNode (sText));
  }

  @NonNull
  public BootstrapDropdownMenu addDropdownMenu (@Nullable final EBootstrapDropdownMenuAlignment eAlignment, @Nullable final String sText)
  {
    return addDropdownMenu (eAlignment, new HCTextNode (sText));
  }

  @NonNull
  public BootstrapDropdownMenu addDropdownMenu (@Nullable final IHCNode aText)
  {
    return addDropdownMenu (EBootstrapDropdownMenuAlignment.DEFAULT, aText);
  }

  @NonNull
  public BootstrapDropdownMenu addDropdownMenu (@Nullable final EBootstrapDropdownMenuAlignment eAlignment, @Nullable final IHCNode aText)
  {
    final IHCLI <?> aLI = addItem ().addClass (CBootstrapCSS.DROPDOWN);
    aLI.addChild (BootstrapDropdown.makeDropdownToggle (new HCA (new SimpleURL ()).addChild (aText)));
    return aLI.addAndReturnChild (new BootstrapDropdownMenu (eAlignment));
  }
}

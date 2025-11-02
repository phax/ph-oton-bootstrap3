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
package com.helger.photon.bootstrap3.navbar;

import java.util.Locale;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.base.id.factory.GlobalIDFactory;
import com.helger.html.EHTMLRole;
import com.helger.html.hc.IHCNode;
import com.helger.html.hc.html.IHCElement;
import com.helger.html.hc.html.IHCElementWithChildren;
import com.helger.html.hc.html.forms.HCButton;
import com.helger.html.hc.html.forms.IHCForm;
import com.helger.html.hc.html.grouping.HCDiv;
import com.helger.html.hc.html.grouping.HCP;
import com.helger.html.hc.html.sections.AbstractHCNav;
import com.helger.html.hc.html.textlevel.HCA;
import com.helger.html.hc.html.textlevel.HCSpan;
import com.helger.html.hc.impl.HCTextNode;
import com.helger.photon.bootstrap3.CBootstrapCSS;
import com.helger.photon.bootstrap3.EBootstrapText;
import com.helger.photon.bootstrap3.base.BootstrapContainer;
import com.helger.photon.bootstrap3.nav.BootstrapNav;
import com.helger.url.ISimpleURL;

/**
 * Bootstrap Navbar
 *
 * @author Philip Helger
 */
public class BootstrapNavbar extends AbstractHCNav <BootstrapNavbar>
{
  private final BootstrapContainer m_aContainer;
  private final BootstrapNavbarHeader m_aHeader;
  private final HCDiv m_aContent;

  public BootstrapNavbar (@NonNull final EBootstrapNavbarType eType, final boolean bCollapsible, @NonNull final Locale aDisplayLocale)
  {
    addClasses (CBootstrapCSS.NAVBAR, CBootstrapCSS.NAVBAR_DEFAULT, eType);
    setRole (EHTMLRole.NAVIGATION);

    m_aContainer = addAndReturnChild (new BootstrapContainer ());
    m_aHeader = m_aContainer.addAndReturnChild (new BootstrapNavbarHeader ());

    // Create the main container
    m_aContent = m_aContainer.addAndReturnChild (new HCDiv ());

    if (bCollapsible)
    {
      // Create a per-instance class for collapsing
      final String sCollapseTarget = "navbar" + GlobalIDFactory.getNewIntID ();

      // Responsive toggle
      final HCButton aToggle = m_aHeader.addAndReturnChild (new HCButton ());
      aToggle.addClass (CBootstrapCSS.NAVBAR_TOGGLE);
      aToggle.customAttrs ().setDataAttr ("toggle", "collapse");
      aToggle.customAttrs ().setDataAttr ("target", "#" + sCollapseTarget);
      aToggle.addChild (new HCSpan ().addClass (CBootstrapCSS.SR_ONLY)
                                     .addChild (EBootstrapText.TOOGLE_NAVIGATION.getDisplayText (aDisplayLocale)));
      aToggle.addChild (new HCSpan ().addClass (CBootstrapCSS.ICON_BAR));
      aToggle.addChild (new HCSpan ().addClass (CBootstrapCSS.ICON_BAR));
      aToggle.addChild (new HCSpan ().addClass (CBootstrapCSS.ICON_BAR));

      m_aContent.addClasses (CBootstrapCSS.COLLAPSE, CBootstrapCSS.NAVBAR_COLLAPSE).setID (sCollapseTarget);
    }
  }

  @NonNull
  public final BootstrapContainer getContainer ()
  {
    return m_aContainer;
  }

  @NonNull
  public final BootstrapNavbarHeader getHeader ()
  {
    return m_aHeader;
  }

  @NonNull
  public final HCDiv getContent ()
  {
    return m_aContent;
  }

  @NonNull
  private BootstrapNavbar _addNode (@NonNull final EBootstrapNavbarPosition ePos, @Nullable final IHCElement <?> aNode)
  {
    if (aNode != null)
      aNode.addClass (ePos);
    if (ePos.isFixed ())
      m_aHeader.addChild (aNode);
    else
      m_aContent.addChild (aNode);
    return this;
  }

  @NonNull
  public BootstrapNavbar addForm (@NonNull final EBootstrapNavbarPosition ePos, @NonNull final IHCForm <?> aForm)
  {
    aForm.addClass (CBootstrapCSS.NAVBAR_FORM);
    return _addNode (ePos, aForm);
  }

  @NonNull
  public BootstrapNavbar addNav (@NonNull final EBootstrapNavbarPosition ePos, @NonNull final BootstrapNav aNav)
  {
    aNav.addClass (CBootstrapCSS.NAVBAR_NAV);
    return _addNode (ePos, aNav);
  }

  @NonNull
  public BootstrapNavbar addText (@NonNull final EBootstrapNavbarPosition ePos, @NonNull final String sText)
  {
    return addText (ePos, new HCP ().addChild (sText));
  }

  @NonNull
  public BootstrapNavbar addText (@NonNull final EBootstrapNavbarPosition ePos, @NonNull final IHCElementWithChildren <?> aText)
  {
    aText.addClass (CBootstrapCSS.NAVBAR_TEXT);
    return _addNode (ePos, aText);
  }

  @NonNull
  public BootstrapNavbar addButton (@NonNull final EBootstrapNavbarPosition ePos, @NonNull final IHCElement <?> aButton)
  {
    aButton.addClass (CBootstrapCSS.NAVBAR_BTN);
    return _addNode (ePos, aButton);
  }

  @NonNull
  public BootstrapNavbar addBrand (@NonNull final String sBrand, @NonNull final ISimpleURL aHomeLink)
  {
    return addBrand (EBootstrapNavbarPosition.FIXED, new HCTextNode (sBrand), aHomeLink);
  }

  @NonNull
  public BootstrapNavbar addBrand (@NonNull final EBootstrapNavbarPosition ePos,
                                   @NonNull final String sBrand,
                                   @NonNull final ISimpleURL aHomeLink)
  {
    return addBrand (ePos, new HCTextNode (sBrand), aHomeLink);
  }

  @NonNull
  public BootstrapNavbar addBrand (@NonNull final IHCNode aBrand, @NonNull final ISimpleURL aHomeLink)
  {
    return addBrand (EBootstrapNavbarPosition.FIXED, aBrand, aHomeLink);
  }

  @NonNull
  public BootstrapNavbar addBrand (@NonNull final EBootstrapNavbarPosition ePos,
                                   @NonNull final IHCNode aBrand,
                                   @NonNull final ISimpleURL aHomeLink)
  {
    return _addNode (ePos, new HCA (aHomeLink).addChild (aBrand).addClass (CBootstrapCSS.NAVBAR_BRAND));
  }

  public boolean isInverse ()
  {
    return containsClass (CBootstrapCSS.NAVBAR_INVERSE);
  }

  @NonNull
  public BootstrapNavbar setInverse (final boolean bInverse)
  {
    if (bInverse)
      addClass (CBootstrapCSS.NAVBAR_INVERSE);
    else
      removeClass (CBootstrapCSS.NAVBAR_INVERSE);
    return this;
  }
}

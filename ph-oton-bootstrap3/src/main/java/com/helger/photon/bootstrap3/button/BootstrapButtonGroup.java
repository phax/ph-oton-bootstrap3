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
package com.helger.photon.bootstrap3.button;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import com.helger.html.EHTMLRole;
import com.helger.html.hc.html.grouping.AbstractHCDiv;
import com.helger.photon.bootstrap3.dropdown.BootstrapDropdown;
import com.helger.photon.bootstrap3.dropdown.BootstrapDropdownMenu;

public class BootstrapButtonGroup extends AbstractHCDiv <BootstrapButtonGroup>
{
  private final EBootstrapButtonGroupType m_eType;
  private final EBootstrapButtonGroupSize m_eSize;

  public BootstrapButtonGroup ()
  {
    this (EBootstrapButtonGroupType.DEFAULT, EBootstrapButtonGroupSize.DEFAULT);
  }

  public BootstrapButtonGroup (@Nonnull final EBootstrapButtonGroupType eType)
  {
    this (eType, EBootstrapButtonGroupSize.DEFAULT);
  }

  public BootstrapButtonGroup (@Nonnull final EBootstrapButtonGroupSize eSize)
  {
    this (EBootstrapButtonGroupType.DEFAULT, eSize);
  }

  public BootstrapButtonGroup (@Nonnull final EBootstrapButtonGroupType eType, @Nonnull final EBootstrapButtonGroupSize eSize)
  {
    addClasses (eType.getAllCSSClasses ());
    addClass (eSize);
    setRole (EHTMLRole.GROUP);
    m_eType = eType;
    m_eSize = eSize;
  }

  @Nonnull
  public EBootstrapButtonGroupType getType ()
  {
    return m_eType;
  }

  @Nonnull
  public EBootstrapButtonGroupSize getSize ()
  {
    return m_eSize;
  }

  @Nonnull
  public BootstrapDropdownMenu addDropDownMenu ()
  {
    final BootstrapDropdownMenu aDDM = addAndReturnChild (new BootstrapDropdownMenu ());
    // Overwrite default "menu" role
    aDDM.setRole (null);
    return aDDM;
  }

  /**
   * Create a new button group with a default button and an additional drop down
   * part.
   *
   * @param aButton
   *        The button to be added. May not be <code>null</code>.
   * @param aMenuItemProvider
   *        The drop down menu item provider.
   * @return The created button group. Never <code>null</code>.
   */
  @Nonnull
  public static BootstrapButtonGroup createButtonAsDropDownMenu (@Nonnull final BootstrapButton aButton,
                                                                 @Nonnull final Consumer <? super BootstrapDropdownMenu> aMenuItemProvider)
  {
    final BootstrapButtonGroup aBG = new BootstrapButtonGroup ();
    BootstrapDropdown.makeDropdownToggle (aButton);
    aBG.addChild (aButton);

    final BootstrapDropdownMenu aMenu = aBG.addDropDownMenu ();
    aMenuItemProvider.accept (aMenu);
    return aBG;
  }

  /**
   * Create a new button group with a default button and an additional drop down
   * part.
   *
   * @param aButton
   *        The button to be added. May not be <code>null</code>.
   * @param aMenuItemProvider
   *        The drop down menu item provider.
   * @return The created button group. Never <code>null</code>.
   */
  @Nonnull
  public static BootstrapButtonGroup createButtonAsDropDownMenuWithSeparateCaret (@Nonnull final BootstrapButton aButton,
                                                                                  @Nonnull final Consumer <? super BootstrapDropdownMenu> aMenuItemProvider)
  {
    final BootstrapButtonGroup aBG = new BootstrapButtonGroup ();
    aBG.addChild (aButton);

    final BootstrapButton aCaret = new BootstrapButton (aButton.getButtonType (), aButton.getButtonSize ());
    BootstrapDropdown.makeDropdownToggle (aCaret);
    aBG.addChild (aCaret);

    final BootstrapDropdownMenu aMenu = aBG.addDropDownMenu ();
    aMenuItemProvider.accept (aMenu);
    return aBG;
  }
}

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
package com.helger.photon.bootstrap3.form;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.Nonnegative;
import com.helger.photon.bootstrap3.grid.BootstrapGridSpec;

/**
 * Mutable interface for a form group container.
 *
 * @author Philip Helger
 */
public interface IMutableBootstrapFormGroupContainer extends IBootstrapFormGroupContainer
{
  /**
   * Set the left part of a horizontal form. This implicitly sets the correct
   * right parts (= CBootstrap.GRID_SYSTEM_MAX - left).
   *
   * @param nLeftParts
   *        The left parts. Must be &ge; 1 and &le; 12!
   * @return this
   */
  @NonNull
  IMutableBootstrapFormGroupContainer setLeft (@Nonnegative int nLeftParts);

  /**
   * Set the left part of a horizontal form. This implicitly sets the correct
   * right parts (= CBootstrap.GRID_SYSTEM_MAX - left).
   *
   * @param nLeftPartsXS
   *        The left parts XS. Must be &ge; 1 and &le; 12!
   * @param nLeftPartsSM
   *        The left parts SM. Must be &ge; 1 and &le; 12!
   * @param nLeftPartsMD
   *        The left parts MD. Must be &ge; 1 and &le; 12!
   * @param nLeftPartsLG
   *        The left parts LG. Must be &ge; 1 and &le; 12!
   * @return this
   */
  @NonNull
  IMutableBootstrapFormGroupContainer setLeft (@Nonnegative int nLeftPartsXS,
                                               @Nonnegative int nLeftPartsSM,
                                               @Nonnegative int nLeftPartsMD,
                                               @Nonnegative int nLeftPartsLG);

  /**
   * Set the left part of a horizontal form.
   *
   * @param aLeft
   *        The left parts. Must not be <code>null</code>.
   * @param aRight
   *        The right parts. Must not be <code>null</code>.
   * @return this
   */
  @NonNull
  IMutableBootstrapFormGroupContainer setSplitting (@NonNull BootstrapGridSpec aLeft, @NonNull BootstrapGridSpec aRight);

  /**
   * Set the form group renderer to be used.
   *
   * @param aFormGroupRenderer
   *        The from group renderer. May not be <code>null</code>.
   * @return this
   */
  @NonNull
  IMutableBootstrapFormGroupContainer setFormGroupRenderer (@NonNull IBootstrapFormGroupRenderer aFormGroupRenderer);

  /**
   * Add a new form group at the end.
   *
   * @param aFormGroup
   *        The form group to be added. May not be <code>null</code>.
   * @return this
   */
  @NonNull
  IMutableBootstrapFormGroupContainer addFormGroup (@NonNull BootstrapFormGroup aFormGroup);
}

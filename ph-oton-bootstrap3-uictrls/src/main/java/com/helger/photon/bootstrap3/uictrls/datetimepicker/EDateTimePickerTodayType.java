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
package com.helger.photon.bootstrap3.uictrls.datetimepicker;

import javax.annotation.Nonnull;

import com.helger.html.jscode.IJSExpression;
import com.helger.html.jscode.JSExpr;

/**
 * Defines the different today types of DTP.
 *
 * @author Philip Helger
 */
public enum EDateTimePickerTodayType
{
  TRUE (JSExpr.TRUE),
  FALSE (JSExpr.FALSE),
  LINKED (JSExpr.lit ("linked"));

  private final IJSExpression m_aJSValue;

  EDateTimePickerTodayType (@Nonnull final IJSExpression aJSValue)
  {
    m_aJSValue = aJSValue;
  }

  @Nonnull
  public IJSExpression getJSValue ()
  {
    return m_aJSValue;
  }
}

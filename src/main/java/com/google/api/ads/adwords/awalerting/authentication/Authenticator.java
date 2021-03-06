// Copyright 2015 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awalerting.authentication;

import com.google.api.ads.adwords.lib.client.AdWordsSession.ImmutableAdWordsSession;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;

/**
 * Authenticator interface for OAuth.
 */
public interface Authenticator {
  /**
   * Authenticates the user against the API(s) depending on the OAuth scope and then returns an
   * {@link com.google.api.ads.adwords.lib.client.AdWordsSession.ImmutableAdWordsSession}.
   *
   * @return the immutable adwords session after the authentication
   * @throws OAuthException error on the OAuth process
   * @throws ValidationException error on the session building process
   */
  ImmutableAdWordsSession authenticate() throws OAuthException, ValidationException;

  /**
   * Obtains an OAuth {@link Credential} configured for AwAlerting by doing the OAuth dance.
   * This method should be invoked for any users for which a refresh token is not known or is
   * invalid.
   *
   * @return
   *    The OAuth2 credential. The scope of the token generated depends on the properties file
   *    configuration. For example<br>
   *    If writing PDF reports to Google Drive, the scope of the token will include both
   *    AdWords and Drive.
   *
   * @throws OAuthException error in obtaining a token
   */
  Credential getOAuth2Credential() throws OAuthException;
}

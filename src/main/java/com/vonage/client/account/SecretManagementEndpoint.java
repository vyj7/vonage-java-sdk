/*
 *   Copyright 2020 Vonage
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.vonage.client.account;

import com.vonage.client.HttpWrapper;

class SecretManagementEndpoint {
    private ListSecretsMethod listSecretsMethod;
    private GetSecretMethod getSecretMethod;
    private CreateSecretMethod createSecretMethod;
    private RevokeSecretMethod revokeSecretMethod;

    SecretManagementEndpoint(HttpWrapper httpWrapper) {
        this.listSecretsMethod = new ListSecretsMethod(httpWrapper);
        this.getSecretMethod = new GetSecretMethod(httpWrapper);
        this.createSecretMethod = new CreateSecretMethod(httpWrapper);
        this.revokeSecretMethod = new RevokeSecretMethod(httpWrapper);

    }

    ListSecretsResponse listSecrets(String apiKey) {
        return this.listSecretsMethod.execute(apiKey);
    }

    SecretResponse getSecret(SecretRequest secretRequest) {
        return this.getSecretMethod.execute(secretRequest);
    }

    SecretResponse createSecret(CreateSecretRequest createSecretRequest) {
        return this.createSecretMethod.execute(createSecretRequest);
    }

    void revokeSecret(SecretRequest secretRequest) {
        this.revokeSecretMethod.execute(secretRequest);
    }
}
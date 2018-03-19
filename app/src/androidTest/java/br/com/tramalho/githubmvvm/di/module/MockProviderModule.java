package br.com.tramalho.githubmvvm.di.module;

import br.com.tramalho.githubmvvm.infraestructure.MockProvider;
import br.com.tramalho.githubmvvm.infraestructure.RemoteProvider;

/**
 * Created by trama on 19/03/18.
 */

public class MockProviderModule extends RemoteProviderModule {

    @Override
    public RemoteProvider providesRemoteProvider() {
        return new MockProvider();
    }
}

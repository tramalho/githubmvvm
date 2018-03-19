package br.com.tramalho.githubmvvm.di;

import br.com.tramalho.githubmvvm.di.module.MockProviderModule;
import br.com.tramalho.githubmvvm.di.module.RemoteProviderModule;

/**
 * Created by trama on 19/03/18.
 */

public class MockComponentBuilder extends ComponentBuilder {

    @Override
    protected RemoteProviderModule getRemoteProviderModule() {
        return new MockProviderModule();
    }
}

package br.com.tramalho.githubmvvm.infraestructure;

/**
 * Created by trama on 19/03/18.
 */

public class MockProvider extends RemoteProvider {
    @Override
    public ServiceApi create() {
        return new MockServiceAPI();
    }
}

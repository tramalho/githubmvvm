package br.com.tramalho.githubmvvm.data.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.tramalho.githubmvvm.data.model.RepoFilter;
import br.com.tramalho.githubmvvm.infraestructure.RemoteProvider;
import br.com.tramalho.githubmvvm.infraestructure.ServiceApi;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by trama on 17/03/18.
 */

public class GithubReposRepositoryTest {

    @Mock
    RemoteProvider remoteProvider;

    @Mock
    ServiceApi serviceApi;

    private GithubReposRepository githubReposRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(remoteProvider.create()).thenReturn(serviceApi);
        githubReposRepository = new GithubReposRepository(remoteProvider);
    }

    @Test
    public void testListByFilter() {
        RepoFilter filter = new RepoFilter("lang", "sort", 1);
        githubReposRepository.listByFilter(filter);
        verify(serviceApi).getReposByFilter("language:" + filter.getLanguage(),
                filter.getSort(), filter.getPageNumber());
    }

    @Test
    public void testOwnerByRepo() {
        String filterStr = "filter";
        githubReposRepository.ownerByRepo(filterStr);
        verify(serviceApi).getRepoOwner(filterStr);
    }

    @Test
    public void testPullRequestRepo() {
        String creator = "creator", repo = "repo";
        githubReposRepository.pullRequestRepo(creator, repo);
        verify(serviceApi).getPullRequests(creator, repo);
    }
}


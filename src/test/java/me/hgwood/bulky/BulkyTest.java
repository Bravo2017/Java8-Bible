package me.hgwood.bulky;

import org.junit.Test;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static me.hgwood.bulky.Bulky.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BulkyTest
{
    private final List<String> uris = asList(
        "http://validUri",
        "ftp://anotherValidUri",
        "invalid\nuri",
        "http://goldenUri",
        "another\ninvalid");

    @Test public void discarding_returns_all_result_successfully_computed() {
        Collection<URI> result = uris.stream()
            .map(lazy(URI::create))
            .collect(discarding(IllegalArgumentException.class))
            .collect(toList());
        assertThat(result, contains(URI.create(uris.get(0)), URI.create(uris.get(1)), URI.create(uris.get(3))));
    }

    @Test(expected = NullPointerException.class)
    public void discardingFailures_lets_runtime_exceptions_propagate_normally() {
        uris.stream()
            .map(lazy(uri -> { throw new NullPointerException(); }))
            .collect(discardingFailures())
            .collect(toList());
    }

    @Test public void lazylift_adds_chained_maps_support() {
        Collection<URI> result = uris.stream()
            .map(lazy(URI::create))
            .map(lazylift(uri -> {
                if (uri.toString().startsWith("ftp")) throw new UnsupportedOperationException();
                else return uri;
            }))
            .collect(discarding(IllegalArgumentException.class, UnsupportedOperationException.class))
            .collect(toList());
        assertThat(result, contains(URI.create(uris.get(0)), URI.create(uris.get(3))));
    }

    @Test public void upTo_returns_results_successfully_computed_before_the_failure() {
        Collection<URI> result = uris.stream()
            .map(lazy(URI::create))
            .collect(upTo(IllegalArgumentException.class))
            .collect(toList());
        assertThat(result, contains(URI.create(uris.get(0)), URI.create(uris.get(1))));
    }

    @Test public void upToAndThrow_throws_an_exception_containing_both_the_cause_and_the_results_successfully_computed_before_the_failure() {
        try {
            uris.stream()
                .map(lazy(URI::create))
                .collect(upToAndThrow(IllegalArgumentException.class));
            fail();
        } catch (FailFastCollectException e) {
            assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
            assertThat(e.getResults(), contains(URI.create(uris.get(0)), URI.create(uris.get(1))));
        }
    }

    @Test public void upToAndThrow_does_not_throw_an_exception_if_all_results_compute_successfully() throws Exception {
        Collection<URI> result = uris.stream().limit(2)
            .map(lazy(URI::create))
            .collect(upToAndThrow(IllegalArgumentException.class))
            .collect(toList());
        assertThat(result, contains(new URI(uris.get(0)), new URI(uris.get(1))));
    }

    @Test public void throwingAtEnd_throws_an_exception_containing_both_all_successfully_computed_results_and_all_thrown_exceptions() {
        try {
            uris.stream()
                .map(lazy(URI::create))
                .collect(throwingAtEnd(IllegalArgumentException.class));
            fail();
        } catch (FailAtEndCollectException e) {
            assertThat(e.getCauses(), contains(
                instanceOf(IllegalArgumentException.class),
                instanceOf(IllegalArgumentException.class)));
            assertThat(e.getResults(), contains(URI.create(uris.get(0)), URI.create(uris.get(1)), URI.create(uris.get(3))));
        }
    }

    @Test public void sneaky_makes_it_work_with_checked_exceptions() {
        Collection<URI> result = uris.stream()
            .map(lazy(sneaky(URI::new)))
            .collect(discardingFailures())
            .collect(toList());
        assertThat(result, contains(URI.create(uris.get(0)), URI.create(uris.get(1)), URI.create(uris.get(3))));
    }
}

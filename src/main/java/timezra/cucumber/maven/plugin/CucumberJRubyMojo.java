package timezra.cucumber.maven.plugin;

import static java.lang.System.clearProperty;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = CucumberJRubyMojo.API_METHOD)
public class CucumberJRubyMojo extends CucumberMojo {

    private static final String GEM_HOME = "GEM_PATH";

    private static final String RUBY_VERSION = "RUBY_VERSION";

    static final String API_METHOD = "jruby";

    @Parameter(property = "ruby_version")
    String ruby_version;

    @Parameter(property = "gem_home")
    String gem_home;

    @Parameter(required = true, property = "feature")
    String feature;

    @Parameter(property = "format", defaultValue = "pretty")
    String format;

    private String originalGemHome;
    private String originalRubyVersion;

    @Override
    protected String[] args() {
        return new String[] { "-f", format, "--glue", feature, feature };
    }

    @Override
    protected void before() {
        originalRubyVersion = getProperty(RUBY_VERSION);
        originalGemHome = getProperty(GEM_HOME);
        if (ruby_version != null) {
            setProperty(RUBY_VERSION, ruby_version);
        }
        if (gem_home != null) {
            setProperty(GEM_HOME, gem_home);
        }
    }

    @Override
    protected void after() {
        if (originalRubyVersion == null) {
            clearProperty(RUBY_VERSION);
        } else {
            setProperty(RUBY_VERSION, originalRubyVersion);
        }
        if (originalGemHome == null) {
            clearProperty(GEM_HOME);
        } else {
            setProperty(GEM_HOME, originalGemHome);
        }
    }
}

package timezra.cucumber.maven.plugin;

import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Env;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

public abstract class CucumberMojo extends AbstractMojo {

    protected abstract String[] args() throws MojoExecutionException;

    @Override
    public final void execute() throws MojoExecutionException, MojoFailureException {
        before();
        try {
            final RuntimeOptions runtimeOptions = new RuntimeOptions(new Env("cucumber-jvm", System.getProperties()), args());
            final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            final ResourceLoader resourceLoader = new MultiLoader(classLoader);
            final ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
            final Runtime runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
            runtime.writeStepdefsJson();
            runtime.run();
            runtime.getErrors();
            if (runtime.exitStatus() != 0) {
                throw new MojoExecutionException("Got non-zero exit status " + runtime.exitStatus());
            }
        } catch (final IOException e) {
            throw new MojoExecutionException("Failure to write Json Stepdefs during Cucumber-JVM run", e);
        } finally {
            after();
        }
    }

    protected void before() {
    };

    protected void after() {
    };
}

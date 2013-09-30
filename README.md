cucumber-jvm-maven-plugin
=========================

A maven plugin for invoking Cucumber-JVM

Configuration
----------------------------------------------------
In order to use this Maven plugin, you will need to configure your pom.xml (or proxy repository) to point to the repository at <http://timezra.github.com/maven/releases>

<code lang="xml">
&nbsp;&nbsp;&nbsp;&nbsp;&lt;pluginRepositories&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;pluginRepository&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;id&gt;tims-repo&lt;/id&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;url&gt;http://timezra.github.com/maven/releases &lt;/url&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;releases&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;enabled&gt;true&lt;/enabled&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/releases&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;snapshots&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;enabled&gt;false&lt;/enabled&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/snapshots&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/pluginRepository&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&lt;/pluginRepositories&gt;
</code>

Usage
----------------------------------------------------
Work in progress....

For now, please use 'mvn timezra.maven:cucumber-jvm-maven-plugin:1.1.5:help' to find out usage information.

### Note ###
Because rvm sets the $GEM_HOME, $GEM_PATH and $RUBY_VERSION environment variables, if you do not wish to use these and wish to configure these values from the plugin, you will need to
    
    $ unset GEM_PATH GEM_HOME RUBY_VERSION

### Examples: ###

#### Running features with Ruby step definitions ####

<code lang="xml">
&nbsp;&nbsp;&lt;build&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&lt;testResources&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;testResource&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;directory&gt;${basedir}/${features-directory}&lt;/directory&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;filtering&gt;true&lt;/filtering&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/testResource&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&lt;/testResources&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&lt;plugins&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;plugin&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;timezra.maven&lt;/groupId&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;cucumber-jvm-maven-plugin&lt;/artifactId&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;1.1.5&lt;/version&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;dependencies&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;dependency&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId&gt;org.jruby&lt;/groupId&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId&gt;jruby-complete&lt;/artifactId&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;version&gt;1.7.4&lt;/version&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/dependency&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/dependencies&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;executions&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;execution&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;phase&gt;test&lt;/phase&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;id&gt;run-cucumbers&lt;/id&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;goals&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;goal&gt;jruby&lt;/goal&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/goals&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;configuration&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;gem_home&gt;${gems-directory}&lt;/gem_home&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;feature&gt;${features-directory}&lt;/feature&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/configuration&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/execution&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/executions&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/plugin&gt;  
&nbsp;&nbsp;&nbsp;&nbsp;&lt;/plugins&gt;  
&nbsp;&nbsp;&lt;/build&gt;
</code>

#### Using the Cucumber-JVM CLI ####
    $ mvn timezra.maven:cucumber-jvm-maven-plugin:1.1.5:cli -Dargs="--help"

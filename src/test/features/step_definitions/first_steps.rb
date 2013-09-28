#encoding: utf-8

# require 'java'
# require 'test/unit'

# require 'rubygems'
# require 'rspec'

require 'cucumber/api/jruby/en'
require 'rspec/expectations'
# include Test::Unit::Assertions

# World do
#   extend RSpec::Matchers
# end

Given /^a cucumber that is (\d+) cm long$/ do |length|
  @cucumber = {:color => 'green', :length => length.to_i}
end

When /^I cut it in halves$/ do 
  @choppedCucumbers = [
    {:color => @cucumber[:color], :length => @cucumber[:length] / 2},
    {:color => @cucumber[:color], :length => @cucumber[:length] / 2}
  ]
end

Then /^I have two cucumbers$/ do 
  @choppedCucumbers.length.should == 2
end

Then /^both are (\d+) cm long$/ do |length|
  @choppedCucumbers.each do |cuke|
    cuke[:length].should == length.to_i
  end
end


#!/usr/bin/env bash
javac -cp "jars/*;." step_definitions/CheckoutSteps.java bank/Checkout.java
java -cp "jars/*;." cucumber.api.cli.Main -p progress --snippets camelcase -g step_definitions features

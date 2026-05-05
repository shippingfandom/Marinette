-- Load bootstrap code into clipb
cat /home/sophie/bootstrap.gls | clipb
-- Remove any tabs
string -r @9 @0 @b | clipb
-- Replace any newline with whitespace
string -r @10 @32 @b | clipb
-- Create file w/ minified code
poke minified.gls @b

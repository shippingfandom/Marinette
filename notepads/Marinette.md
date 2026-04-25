# Marinette Reference

This reference covers the functions, macros, and commands provided by Marinette. Marinette consists of three main files: `5hell.gls`, `marinette.gls`, and `do.gls`.

---

## Table of Contents

- [Functions](#functions)
- [Macros](#macros)
- [Commands](#commands)

---

## Functions

Core utility functions used throughout Marinette

<details open>
<summary>**#** - Returns a specific argument from an args array with optio...</summary>

> Returns a specific argument from an args array with optional fallback value.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| args | array | The arguments array |
| idx | number | The index to retrieve |
| fallback | any | The fallback value if index doesn't exist |

Returns: The value at the given index, or the fallback

```clojure
(# args 0 '')
```

```clojure
(# args 1 'default')
```

```clojure
(# args 5 'not-found')
```
</details>

<details open>
<summary>**mari-bang** - Generates the custom Marinette prompt with user info, dat...</summary>

> Generates the custom Marinette prompt with user info, date, time, buffer index, hostname, addresses, and pwd.

From: [do.gls](../glosure/do.gls)

| Parameters | Multiple | Various prompt components |
|------------|----------|-------------------|
| Various | any | Multiple parameters for prompt generation |

Returns: The formatted prompt string

```clojure
(mari-bang angle part1 part2 user_level user_level_line info pspace part3 scadoosh user_guess bang)
```
</details>

<details open>
<summary>**mari-buffer-top-debug-library** - Searches the BUFFER for the topmost debug library object</summary>

> Searches the BUFFER for the topmost debug library object.

From: [marinette.gls](../glosure/marinette.gls)

Returns: A debugLibrary object if found, null otherwise

```clojure
(mari-buffer-top-debug-library)
```

```clojure
(def debug-lib (mari-buffer-top-debug-library))
```
</details>

<details open>
<summary>**mari-color-ascii-art** - Colors ASCII art by applying color formatting to each line</summary>

> Colors ASCII art by applying color formatting to each line.

From: [do.gls](../glosure/do.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| ascii-art | string | The ASCII art to color |

Returns: The colored ASCII art string

```clojure
(mari-color-ascii-art art-content)
```
</details>

<details open>
<summary>**mari-computerify** - Converts a shell to a computer, or returns the computer i...</summary>

> Converts a shell to a computer, or returns the computer if already a computer object.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| object | any | The shell or computer object |

Returns: A computer object

```clojure
(mari-computerify my-shell)
```

```clojure
(mari-computerify target-computer)
```
</details>

<details open>
<summary>**mari-format-help-like** - Formats an array into columns similar to help display, wi...</summary>

> Formats an array into columns similar to help display, with color formatting.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| arr | array | The array to format |

Returns: A formatted string with columns

```clojure
(mari-format-help-like (array 'a1' 'a2' 'a3'))
```

```clojure
(mari-format-help-like (mari-get-additions))
```
</details>

<details open>
<summary>**mari-format-tws-like** - Formats an object into a TWS-like string: `[buf-idx]user:...</summary>

> Formats an object into a TWS-like string: `[buf-idx]user:obj-type@pub-ip/loc-ip`.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| object | any | The object to format |

Returns: A formatted string

```clojure
(mari-format-tws-like target-shell)
```

```clojure
(mari-format-tws-like some-computer)
```
</details>

<details open>
<summary>**mari-get-additions** - Gets all commands added by Marinette (commands without "M...</summary>

> Gets all commands added by Marinette (commands without "Marinette specific functionality" in help).

From: [marinette.gls](../glosure/marinette.gls)

Returns: A sorted array of added command names

```clojure
(mari-get-additions)
```
</details>

<details open>
<summary>**mari-get-binary** - Gets a binary file from rkit/marinette/binaries by name</summary>

> Gets a binary file from rkit/marinette/binaries by name.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| binary-name | string | The name of the binary to find |

Returns: A file object if found, null otherwise

```clojure
(mari-get-binary 'crypto.so')
```

```clojure
(mari-get-binary 'metaxploit.so')
```
</details>

<details open>
<summary>**mari-get-current-object** - Gets the current shell or computer object based on networ...</summary>

> Gets the current shell or computer object based on network position.

From: [marinette.gls](../glosure/marinette.gls)

Returns: The current shell or computer object

```clojure
(mari-get-current-object)
```

```clojure
(def current (mari-get-current-object))
```
</details>

<details open>
<summary>**mari-get-glosure-scripts** - Retrieves all glosure script files from rkit/marinette/sc...</summary>

> Retrieves all glosure script files from rkit/marinette/scripts.

From: [marinette.gls](../glosure/marinette.gls)

Returns: An array of file objects

```clojure
(mari-get-glosure-scripts)
```

```clojure
(def scripts (mari-get-glosure-scripts))
```
</details>

<details open>
<summary>**mari-get-modifications** - Gets all commands modified by Marinette (commands with "M...</summary>

> Gets all commands modified by Marinette (commands with "Marinette specific functionality" in help).

From: [marinette.gls](../glosure/marinette.gls)

Returns: A sorted array of modified command names

```clojure
(mari-get-modifications)
```
</details>

<details open>
<summary>**mari-get-notepad** - Gets a notepad file from rkit/marinette/notepads by name</summary>

> Gets a notepad file from rkit/marinette/notepads by name.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| notepad-name | string | The name of the notepad to find |

Returns: A file object if found, null otherwise

```clojure
(mari-get-notepad 'ascii.txt')
```

```clojure
(mari-get-notepad 'notes.txt')
```
</details>

<details open>
<summary>**mari-get-scripts** - Gets all macros starting with `%` (glosure scripts)</summary>

> Gets all macros starting with `%` (glosure scripts).

From: [marinette.gls](../glosure/marinette.gls)

Returns: A sorted array of script names

```clojure
(mari-get-scripts)
```

```clojure
(def glosure-scripts (mari-get-scripts))
```
</details>

<details open>
<summary>**mari-get-total-changes** - Gets all added and modified commands (total changes)</summary>

> Gets all added and modified commands (total changes).

From: [marinette.gls](../glosure/marinette.gls)

Returns: A sorted array of command names

```clojure
(mari-get-total-changes)
```
</details>

<details open>
<summary>**mari-load-theme** - Loads a custom color theme from a file in rkit/marinette/...</summary>

> Loads a custom color theme from a file in rkit/marinette/themes.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| theme | string | The name of the theme file to load |

Returns: null

```clojure
(mari-load-theme 'soft.src')
```

```clojure
(mari-load-theme 'dark.theme')
```
</details>

<details open>
<summary>**mari-local-address** - Gets the local IP address of a shell or computer</summary>

> Gets the local IP address of a shell or computer.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| object | any | The shell or computer object |

Returns: A string containing the local IP address

```clojure
(mari-local-address target-shell)
```

```clojure
(mari-local-address some-computer)
```
</details>

<details open>
<summary>**mari-match** - Performs regex matching on a string, supporting per-line ...</summary>

> Performs regex matching on a string, supporting per-line matching.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| string | string | The string to match against |
| pattern | string | The regex pattern |

Returns: 1 if matched, 0 otherwise

```clojure
(mari-match 'hello world' '^hello')
```

```clojure
(mari-match 'line1\nline2' 'line1')
```
</details>

<details open>
<summary>**mari-mkdir** - Creates a directory inside the rkit/marinette folder</summary>

> Creates a directory inside the rkit/marinette folder.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| dirname | string | The name of the directory to create |

Returns: null

```clojure
(mari-mkdir 'themes')
```

```clojure
(mari-mkdir 'scripts')
```
</details>

<details open>
<summary>**mari-mkdir-hidden-infil** - Creates a hidden directory with a random name inside a co...</summary>

> Creates a hidden directory with a random name inside a computer's folder structure.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| computer | computer | The computer object to create the hidden folder in |

Returns: A file object pointing to the created hidden directory, or null

```clojure
(mari-mkdir-hidden-infil my-computer)
```

```clojure
(mari-mkdir-hidden-infil ((|> localmachine)))
```
</details>

<details open>
<summary>**mari-printline** - Outputs a message with the Marinette prefix and color for...</summary>

> Outputs a message with the Marinette prefix and color formatting.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| str-array | array | An array of strings to join and print |

Returns: The formatted output string

```clojure
(mari-printline (array 'Loading complete!'))
```

```clojure
(mari-printline (array 'Version: ' version))
```
</details>

<details open>
<summary>**mari-public-address** - Gets the public IP address of a shell or computer</summary>

> Gets the public IP address of a shell or computer.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| object | any | The shell or computer object |

Returns: A string containing the public IP address

```clojure
(mari-public-address target-shell)
```

```clojure
(mari-public-address some-computer)
```
</details>

<details open>
<summary>**mari-show-ascii-art** - Displays ASCII art on startup if on host and ASCII art ha...</summary>

> Displays ASCII art on startup if on host and ASCII art hasn't been shown yet.

From: [marinette.gls](../glosure/marinette.gls)

Returns: null

```clojure
(mari-show-ascii-art)
```
</details>

<details open>
<summary>**mari-sort-macros** - Sorts all defined 5hell macros alphabetically by their names</summary>

> Sorts all defined 5hell macros alphabetically by their names.

From: [marinette.gls](../glosure/marinette.gls)

Returns: null

```clojure
(mari-sort-macros)
```
</details>

<details open>
<summary>**mari-undercover-buffer** - Gets the undercover buffer (stores shells/computers from ...</summary>

> Gets the undercover buffer (stores shells/computers from ghost infiltration).

From: [marinette.gls](../glosure/marinette.gls)

Returns: An array (buffer)

```clojure
(mari-undercover-buffer)
```

```clojure
(def buffer (mari-undercover-buffer))
```
</details>

<details open>
<summary>**mari-undercover-buffer-push** - Pushes a value to the undercover buffer</summary>

> Pushes a value to the undercover buffer.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| value | any | The value to push |

Returns: null

```clojure
(mari-undercover-buffer-push target-shell)
```

```clojure
(mari-undercover-buffer-push some-computer)
```
</details>

<details open>
<summary>**mari-update-hacking-libraries** - Updates hacking libraries (`crypto.so` and `metaxploit.so...</summary>

> Updates hacking libraries (`crypto.so` and `metaxploit.so`) in both /lib and rkit.

From: [marinette.gls](../glosure/marinette.gls)

Returns: null

```clojure
(mari-update-hacking-libraries)
```
</details>

<details open>
<summary>**mari-tws-list** - Executes a TWS (total world scan) query and returns a lis...</summary>

> Executes a TWS (total world scan) query and returns a list of buffer indexes.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| query | string | The TWS query to execute |

Returns: An array of buffer indexes

```clojure
(mari-tws-list 'FG')
```

```clojure
(mari-tws-list 'open')
```
</details>

<details open>
<summary>**mari-tws-look** - Finds the buffer index of an object matching given user, ...</summary>

> Finds the buffer index of an object matching given user, object type, public address, and local address.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| user | string | The username to search for |
| object-type | string | The type of object (e.g., 'file', 'shell') |
| public-address | string | The public IP address |
| local-address | string | The local IP address |

Returns: The buffer index, or -1 if not found

```clojure
(mari-tws-look 'root' 'shell' '1.2.3.4' '10.0.0.1')
```

```clojure
(mari-tws-look 'guest' 'computer' '5.6.7.8' '0')
```
</details>

<details open>
<summary>**mari-args** - Returns arguments from the macro pipe, parsing the pipe c...</summary>

> Returns arguments from the macro pipe, parsing the pipe content into an array of string arguments.

From: [marinette.gls](../glosure/marinette.gls)

Returns: An array of string arguments

```clojure
(mari-args)
```

```clojure
(def args (mari-args))
```
</details>

<details open>
<summary>**gl-all** - Returns 1 if all conditions in the array evaluate to a tr...</summary>

> Returns 1 if all conditions in the array evaluate to a truthy value.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| conditions | array | An array of conditions to check |

Returns: 1 if all conditions are truthy, 0 otherwise

```clojure
(gl-all (array (== status 'active') (> score 100)))
```

```clojure
(gl-all (array 'valid' 1 'confirmed'))
```
</details>

<details open>
<summary>**gl-any** - Returns 1 if any of the conditions in the array evaluate ...</summary>

> Returns 1 if any of the conditions in the array evaluate to a truthy value.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| conditions | array | An array of conditions to check |

Returns: 1 if any condition is truthy, 0 otherwise

```clojure
(gl-any (array (== status 'active') (> score 100)))
```

```clojure
(gl-any (array null 0 ''))
```
</details>

<details open>
<summary>**gl-break-silence** - Temporarily breaks through the `SILENT` flag to print a m...</summary>

> Temporarily breaks through the `SILENT` flag to print a message, then restores the previous SILENT state.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| message | any | The message to print |

Returns: The message that was printed

```clojure
(gl-break-silence "Important system message")
```

```clojure
(gl-break-silence (array "Current user: " current_user))
```
</details>

<details open>
<summary>**gl-get-rkit** - Locates the rkit folder from the 5hell launch directory</summary>

> Locates the rkit folder from the 5hell launch directory.

From: [5hell.gls](../glosure/5hell.gls)

Returns: A file object pointing to the rkit folder, or null if not found

```clojure
(def my-rkit (gl-get-rkit))
```

```clojure
((|> file) '-p' (gl-get-rkit))
```
</details>

<details open>
<summary>**gl-grep-into** - Greps into every step from the previous step, starting fr...</summary>

> Greps into every step from the previous step, starting from an optional starting point.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| steps | array | An array of grep patterns to apply sequentially |
| starting-point | string | Optional starting file path |

Returns: A file object if successful, null otherwise

```clojure
(gl-grep-into (array '^config$') 0)
```

```clojure
(gl-grep-into (array '^data$' '^settings$') '/home/guest')
```
</details>

<details open>
<summary>**gl-is-file-text** - Checks if a file is a text file (not a folder and not bin...</summary>

> Checks if a file is a text file (not a folder and not binary).

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| file | file | The file object to check |

Returns: 1 if the file is a text file, 0 otherwise

```clojure
(gl-is-file-text some-file)
```

```clojure
(gl-is-file-text ((|> file) '-r' '/path/to/file'))
```
</details>

<details open>
<summary>**gl-pathcat** - Concatenates multiple path parts into a single path strin...</summary>

> Concatenates multiple path parts into a single path string, properly handling path separators.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| paths | array | An array of path parts to concatenate |

Returns: A string containing the concatenated path

```clojure
(gl-pathcat (array '/home/guest' 'documents' 'file.txt'))
```

```clojure
(gl-pathcat (array rkit-path 'themes' 'theme.src'))
```
</details>

<details open>
<summary>**gl-printline** - Outputs a message with the 5hell Glosure Library prefix a...</summary>

> Outputs a message with the 5hell Glosure Library prefix and color formatting.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| str-array | array | An array of strings to join and print |

Returns: The formatted output string

```clojure
(gl-printline (array 'Loading complete!'))
```

```clojure
(gl-printline (array 'Version: ' version-number))
```
</details>

<details open>
<summary>**gl-random-string** - Generates a random string of specified length using alpha...</summary>

> Generates a random string of specified length using alphanumeric characters.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| length | number | The desired length of the random string |

Returns: A string of random characters

```clojure
(gl-random-string 8)
```

```clojure
(gl-random-string 16)
```
</details>

---

## Macros

Special forms that evaluate their arguments differently

<details open>
<summary>**@** - Gets a variable from the Custom Object (COB)</summary>

> Gets a variable from the Custom Object (COB).

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| var-name | symbol | The name of the variable to get |

Returns: The value of the variable, or null if not found

```clojure
(@ HOME)
```

```clojure
(@ PIPE)
```
</details>

<details open>
<summary>**@=** - Sets a variable in the Custom Object (COB)</summary>

> Sets a variable in the Custom Object (COB).

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| var-name | symbol | The name of the variable to set |
| var-value | any | The value to set |

Returns: null

```clojure
(@= PIPE 'some value')
```

```clojure
(@= HOME (dict))
```
</details>

<details open>
<summary>**_** - Gets a method from an object (miniscript accessor)</summary>

> Gets a method from an object (miniscript accessor).

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| object | any | The object to get the method from |
| method | symbol | The name of the method |

Returns: The method, or null

```clojure
(_ file 'get_content')
```

```clojure
(_ some-object 'some_method')
```
</details>

<details open>
<summary>**:=** - Sets a global variable</summary>

> Sets a global variable.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| var-name | symbol | The name of the global variable |
| var-value | any | The value to set |

Returns: null

```clojure
(:= SILENT 0)
```

```clojure
(:= command some-command)
```
</details>

<details open>
<summary>**:** - Gets a global variable</summary>

> Gets a global variable.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| var-name | symbol | The name of the global variable |

Returns: The value of the global variable, or null

```clojure
(: command)
```

```clojure
(: SILENT)
```
</details>

<details open>
<summary>**|=** - Defines and registers a new command in globals.command</summary>

> Defines and registers a new command in globals.command.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| cmd-name | symbol | The name of the command |
| cmd-args | array | Arguments for the command |
| cmd-body | any | The body of the command |

Returns: null

```clojure
(|= mycommand (a1 a2) (...))
```

```clojure
(|= myfunc () (...))
```
</details>

<details open>
<summary>**|>** - Gets a command from globals.command</summary>

> Gets a command from globals.command.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| cmd-name | symbol | The name of the command |

Returns: The command function, or null

```clojure
(|> file)
```

```clojure
(|> grep)
```
</details>

<details open>
<summary>**>>** - Creates and registers a 5shell macro</summary>

> Creates and registers a 5shell macro.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| macroname | symbol | The name of the macro |
| args | array | Arguments (uses mari-args internally) |
| macrobody | any | The body of the macro |

Returns: null

```clojure
(>> mymacro @pipe (...))
```

```clojure
(>> gls @pipe (...))
```
</details>

<details open>
<summary>**defaultvalue** - Sets a default value for a parameter in the context if it...</summary>

> Sets a default value for a parameter in the context if it's currently null.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| parameter-name | symbol | The parameter name |
| parameter-value | any | The default value |

Returns: null

```clojure
(defaultvalue a2 0)
```

```clojure
(defaultvalue path '/default/path')
```
</details>

---

## Commands

Shell commands provided or modified by Marinette

<details open>
<summary>**aptm** - Repository updating with Marinette enhancements</summary>

> Repository updating with Marinette enhancements.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of the operation

```clojure
aptm -U
```

```clojure
aptm -update
```
</details>

<details open>
<summary>**ariadne** - Escalation attack using the configured escalation library</summary>

> Escalation attack using the configured escalation library.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of the escalation attempt

```clojure
ariadne
```

```clojure
ariadne MEMORY
```
</details>

<details open>
<summary>**ascii** - Display ASCII art from rkit/marinette/notepads/ascii.txt</summary>

> Display ASCII art from rkit/marinette/notepads/ascii.txt.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: ASCII art content or null

```clojure
ascii
```
</details>

<details open>
<summary>**bounce** - Bounce attack using bounce library</summary>

> Bounce attack using bounce library.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Target address |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of the bounce attempt

```clojure
bounce 192.168.1.100
```

```clojure
bounce 10.0.0.1
```
</details>

<details open>
<summary>**breach** - Disable firewall on the entire local network</summary>

> Disable firewall on the entire local network.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Memory address |
| a2 | string | Value to use |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of the breach operation

```clojure
breach MEMORY VALUE
```

```clojure
breach 0x1000 test
```
</details>

<details open>
<summary>**buf** - Shows the malwire buffer or help</summary>

> Shows the malwire buffer or help.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Buffer content or help information

```clojure
buf
```

```clojure
buf -h
```
</details>

<details open>
<summary>**cls** - Clears the screen</summary>

> Clears the screen.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command arguments |

Returns: null

```clojure
cls
```
</details>

<details open>
<summary>**close** - Closes the current shell session</summary>

> Closes the current shell session.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Closing message

```clojure
close
```

```clojure
close -h
```
</details>

<details open>
<summary>**del** - Deletes files with additional help handling</summary>

> Deletes files with additional help handling.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | File path or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of the delete operation

```clojure
del file.txt
```

```clojure
del -h
```

```clojure
del -r file.txt
```
</details>

<details open>
<summary>**dir** - Directory listing alias (wraps `ls -la`)</summary>

> Directory listing alias (wraps `ls -la`).

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Path or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Directory listing

```clojure
dir
```

```clojure
dir /path
```
</details>

<details open>
<summary>**explorer** - Open FileExplorer.exe at specified path</summary>

> Open FileExplorer.exe at specified path.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Path or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of opening explorer

```clojure
explorer
```

```clojure
explorer /path
```
</details>

<details open>
<summary>**glasspool** - Mirror session with mimi on mirrored objects</summary>

> Mirror session with mimi on mirrored objects.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Target or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of glasspool operation

```clojure
glasspool target
```
</details>

<details open>
<summary>**gls** - Executes a glosure script file</summary>

> Executes a glosure script file.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Path to script |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of script execution

```clojure
gls /path/to/script.gls
```

```clojure
gls scripts/my-script.gls
```
</details>

<details open>
<summary>**hashcat** - Hash cracking using host crypto library instead of loaded...</summary>

> Hash cracking using host crypto library instead of loaded one.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Hash file or string |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Cracked hash result

```clojure
hashcat /path/to/file
```

```clojure
hashcat hash-string
```
</details>

<details open>
<summary>**infil** - Infiltrate target with ability to upload rkit folder</summary>

> Infiltrate target with ability to upload rkit folder.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | File or flags |
| a2 | string | Target shell or arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of infiltration

```clojure
infil file.txt
```

```clojure
infil -g shell
```

```clojure
infil -G shell
```
</details>

<details open>
<summary>**kraken** - Hack random NPCs and populate Map.conf</summary>

> Hack random NPCs and populate Map.conf.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command or flags |
| a2 | string | Count |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of kraken operation

```clojure
kraken -r 5
```

```clojure
kraken random 10
```
</details>

<details open>
<summary>**macros** - Lists all macros</summary>

> Lists all macros.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Command arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: List of macros

```clojure
macros
```

```clojure
macros -h
```
</details>

<details open>
<summary>**marinette** - Show Marinette statistics, credits, scripts, additions, o...</summary>

> Show Marinette statistics, credits, scripts, additions, or modifications.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Subcommand (credits, scripts, additions, modifications) |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Requested information

```clojure
marinette
```

```clojure
marinette credits
```

```clojure
marinette scripts
```

```clojure
marinette additions
```

```clojure
marinette modifications
```
</details>

<details open>
<summary>**match** - Pattern matching using regular expressions</summary>

> Pattern matching using regular expressions.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Pattern |
| a2 | string | String to match |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: 1 if matched, 0 otherwise

```clojure
match "pattern" "string to match"
```

```clojure
match "hello" "hello world"
```
</details>

<details open>
<summary>**mimi** - Check for online administrators or players (eavesdropping)</summary>

> Check for online administrators or players (eavesdropping).

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Target or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Status code (0, 1, 2, or 3)

```clojure
mimi
```

```clojure
mimi shell-object
```

```clojure
mimi computer-object
```
</details>

<details open>
<summary>**nemesis** - Hacking utility using database exploitation</summary>

> Hacking utility using database exploitation.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Address |
| a2 | string | Port |
| a3 | string | Inject code |
| a4 | string | Additional arguments |

Returns: Result of hacking attempt

```clojure
nemesis 1.1.1.1 0
```

```clojure
nemesis 1.1.1.1 0 inject-code
```
</details>

<details open>
<summary>**netstalk** - Network stalking - probes random networks until pattern m...</summary>

> Network stalking - probes random networks until pattern matches.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Pattern to match |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: IP address if matched

```clojure
netstalk ssh
```

```clojure
netstalk "gateway.*1\.2\.3"
```
</details>

<details open>
<summary>**nmap** - Network mapper alias with purge prep and probe functionality</summary>

> Network mapper alias with purge prep and probe functionality.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Target |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Network mapping result

```clojure
nmap 192.168.1.1
```

```clojure
nmap -s 192.168.1.0/24
```
</details>

<details open>
<summary>**notepad** - Open Notepad.exe at specified path</summary>

> Open Notepad.exe at specified path.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Path or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of opening notepad

```clojure
notepad
```

```clojure
notepad /path/to/file.txt
```
</details>

<details open>
<summary>**nslookup** - Performs DNS lookup (wraps `nsl` command)</summary>

> Performs DNS lookup (wraps `nsl` command).

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Host or IP |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: DNS lookup result

```clojure
nslookup example.com
```

```clojure
nslookup 8.8.8.8
```
</details>

<details open>
<summary>**prox** - Proxy connection with ghost 5hell option</summary>

> Proxy connection with ghost 5hell option.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Port or flags |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of proxy connection

```clojure
prox port
```

```clojure
prox -g
```

```clojure
prox -G
```
</details>

<details open>
<summary>**purge** - Purge with undercover buffer purge option</summary>

> Purge with undercover buffer purge option.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Flags or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of purge operation

```clojure
purge
```

```clojure
purge -uc
```
</details>

<details open>
<summary>**rclean** - Remote clean with mimi integration</summary>

> Remote clean with mimi integration.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Target |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of clean operation

```clojure
rclean shell
```

```clojure
rclean computer
```
</details>

<details open>
<summary>**run** - Run executable with shell as first argument support</summary>

> Run executable with shell as first argument support.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Executable path or shell |
| a2 | string | Arguments or shell |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of running executable

```clojure
run /path/to/exe
```

```clojure
run executable shell-object arg
```
</details>

<details open>
<summary>**shell** - Shell command with mimi when in mirror session</summary>

> Shell command with mimi when in mirror session.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| input | string | Input for shell |
| mute | string | Mute flag |

Returns: Shell result

```clojure
shell
```
</details>

<details open>
<summary>**ssh** - SSH connection with HOME server and automatic mimi</summary>

> SSH connection with HOME server and automatic mimi.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | User@host or flags |
| a2 | string | Password or host |
| a3 | string | Port or additional arguments |
| a4 | string | Additional arguments |

Returns: SSH shell

```clojure
ssh user@host
```

```clojure
ssh -H
```
</details>

<details open>
<summary>**silentclean** - Silent clean with mimi on targets</summary>

> Silent clean with mimi on targets.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Target or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of silent clean

```clojure
silentclean
```

```clojure
silentclean target
```
</details>

<details open>
<summary>**su** - Switch user command with multiple behavior modes</summary>

> Switch user command with multiple behavior modes.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Username or flags |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of su operation

```clojure
su username
```

```clojure
su -n username
```

```clojure
su -u username
```
</details>

<details open>
<summary>**touch** - Alias for `poke` - creates or modifies a file</summary>

> Alias for `poke` - creates or modifies a file.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | File path |
| a2 | string | Content or arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of touch operation

```clojure
touch file.txt
```

```clojure
touch /path/to/file new-content
```
</details>

<details open>
<summary>**type** - Gets the type of an object</summary>

> Gets the type of an object.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Object to check |

Returns: Type string

```clojure
type some-object
```

```clojure
type "string"
```
</details>

<details open>
<summary>**uc** - Undercover alias</summary>

> Undercover alias.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of undercover operation

```clojure
uc
```

```clojure
uc -b
```
</details>

<details open>
<summary>**undercover** - Cover traces after infiltration, or manage undercover buffer</summary>

> Cover traces after infiltration, or manage undercover buffer.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Flags or arguments |
| a2 | string | Additional arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of undercover operation

```clojure
undercover
```

```clojure
undercover -b
```

```clojure
undercover -b shell
```

```clojure
undercover -c
```
</details>

<details open>
<summary>**unlock** - Unlocks all permissions on the current object (guest user...</summary>

> Unlocks all permissions on the current object (guest user access).

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Input for confirmation |

Returns: Result of unlock operation

```clojure
unlock
```
</details>

<details open>
<summary>**view** - View various file types using graphical viewers</summary>

> View various file types using graphical viewers.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Flag ( -l, -i, -p) |
| a2 | string | Path to file |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of viewing file

```clojure
view -l
```

```clojure
view -i image.png
```

```clojure
view -p document.pdf
```
</details>

<details open>
<summary>**zap** - Exploit attack with automatic player/admin detection</summary>

> Exploit attack with automatic player/admin detection.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Address or flags |
| a2 | string | Memory or arguments |
| a3 | string | Additional arguments |
| a4 | string | Additional arguments |

Returns: Result of zap operation

```clojure
zap address memory
```

```clojure
zap -l
```
</details>

<details open>
<summary>**zc** - Zero Chill - library patching utility with multiple modes</summary>

> Zero Chill - library patching utility with multiple modes.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| a1 | string | Mode flag |
| a2 | string | Target or user |
| a3 | string | Password or additional arguments |
| a4 | string | Additional arguments |

Returns: Result of zc operation

```clojure
zc -i /path/to/lib
```

```clojure
zc -e address
```

```clojure
zc -p user password /path/to/lib
```
</details>

# Marinette Reference

This reference covers the functions, macros, and commands provided by Marinette.

---

## Table of Contents

- [Functions](#functions)
- [Macros](#macros)

---

## Functions

Core utility functions used throughout Marinette

<details open>
<summary>#</summary>

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
<summary>gl-all</summary>

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
<summary>gl-any</summary>

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
<summary>gl-break-silence</summary>

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
(gl-break-silence (join (array "Current user: " current_user) ''))
```
</details>

<details open>
<summary>gl-get-rkit</summary>

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
<summary>gl-grep-into</summary>

> Greps into every step from the previous step, starting from an optional starting point.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| steps | array | An array of grep patterns to apply sequentially |
| starting-point | string or file | Optional starting file path |

Returns: A file object if successful, null otherwise

```clojure
(gl-grep-into (array '^config$') 0)
```

```clojure
(gl-grep-into (array '^data$' '^settings$') '/home/guest')
```
</details>

<details open>
<summary>gl-is-file-text</summary>

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
<summary>gl-pathcat</summary>

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
<summary>gl-printline</summary>

> Outputs a message with the 5hell Glosure Library prefix and color formatting.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| str-array | array or string | A string or an array of strings to join and print |

Returns: The formatted output string

```clojure
(gl-printline (array 'Loading complete!'))
```

```clojure
(gl-printline (array 'Version: ' version-number))
```
</details>

<details open>
<summary>gl-random-string</summary>

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

<details open>
<summary>mari-bang</summary>

> Generates the custom Marinette prompt with user info, date, time, buffer index, hostname, addresses, and pwd.

From: [marinette.gls](../glosure/marinette.gls)

Returns: The formatted prompt string

```clojure
(mari-bang angle part1 part2 user_level user_level_line info pspace part3 scadoosh user_guess bang)
```
</details>

<details open>
<summary>mari-buffer-top-debug-library</summary>

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
<summary>mari-color-ascii-art</summary>

> User-specified ASCII art coloring function.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| ascii-art | string | The ASCII art to color |

Returns: The colored ASCII art string

```clojure
(mari-color-ascii-art art-content)
```
</details>

<details open>
<summary>mari-computerify</summary>

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
<summary>mari-format-help-like</summary>

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
<summary>mari-format-tws-like</summary>

> Formats an object into a TWS-like string: `[buf-idx]user:obj-type@pub-ip/loc-ip`.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| object | any | Shell or computer to format |

Returns: A formatted string

```clojure
(mari-format-tws-like target-shell)
```

```clojure
(mari-format-tws-like some-computer)
```
</details>

<details open>
<summary>mari-get-additions</summary>

> Gets all commands added by Marinette (commands without "Marinette specific functionality" in help).

From: [marinette.gls](../glosure/marinette.gls)

Returns: A sorted array of added command names

```clojure
(mari-get-additions)
```
</details>

<details open>
<summary>mari-get-binary</summary>

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
<summary>mari-get-current-object</summary>

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
<summary>mari-get-glosure-scripts</summary>

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
<summary>mari-get-modifications</summary>

> Gets all commands modified by Marinette (commands with "Marinette specific functionality" in help).

From: [marinette.gls](../glosure/marinette.gls)

Returns: A sorted array of modified command names

```clojure
(mari-get-modifications)
```
</details>

<details open>
<summary>mari-get-notepad</summary>

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
<summary>mari-get-scripts</summary>

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
<summary>mari-get-total-changes</summary>

> Gets all added and modified commands (total changes).

From: [marinette.gls](../glosure/marinette.gls)

Returns: A sorted array of command names

```clojure
(mari-get-total-changes)
```
</details>

<details open>
<summary>mari-load-theme</summary>

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
<summary>mari-local-address</summary>

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
<summary>mari-match</summary>

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
<summary>mari-mkdir</summary>

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
<summary>mari-mkdir-hidden-infil</summary>

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
<summary>mari-printline</summary>

> Outputs a message with the Marinette prefix and color formatting.

From: [marinette.gls](../glosure/marinette.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| str-array | array or string | A string or an array of strings to join and print |

Returns: The formatted output string

```clojure
(mari-printline (array 'Loading complete!'))
```

```clojure
(mari-printline (array 'Version: ' version))
```
</details>

<details open>
<summary>mari-public-address</summary>

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
<summary>mari-show-ascii-art</summary>

> Displays ASCII art on startup if on host and ASCII art hasn't been shown yet.

From: [marinette.gls](../glosure/marinette.gls)

Returns: null

```clojure
(mari-show-ascii-art)
```
</details>

<details open>
<summary>mari-sort-macros</summary>

> Sorts all defined 5hell macros alphabetically by their names.

From: [marinette.gls](../glosure/marinette.gls)

Returns: null

```clojure
(mari-sort-macros)
```
</details>

<details open>
<summary>mari-undercover-buffer</summary>

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
<summary>mari-undercover-buffer-push</summary>

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
<summary>mari-update-hacking-libraries</summary>

> Updates hacking libraries (`crypto.so` and `metaxploit.so`) in both /lib and rkit.

From: [marinette.gls](../glosure/marinette.gls)

Returns: null

```clojure
(mari-update-hacking-libraries)
```
</details>

<details open>
<summary>mari-tws-list</summary>

> Executes a TWS (Track While Scan) query and returns a list of buffer indexes.

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
<summary>mari-tws-look</summary>

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
<summary>mari-args</summary>

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

---

## Macros

Special forms that evaluate their arguments differently

<details open>
<summary>@</summary>

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
<summary>@=</summary>

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
<summary>_</summary>

> Gets a method from an object (miniscript accessor).

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| object | any | The object to get the method from |
| method | symbol | The name of the method |

Returns: The method, or null

```clojure
((_ file get_content) file)
```

```clojure
((_ some-object some_method) some-object)
```
</details>

<details open>
<summary>:=</summary>

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
<summary>:</summary>

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
<summary>|=</summary>

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
<summary>|></summary>

> Gets a command from globals.command.

From: [5hell.gls](../glosure/5hell.gls)

| Parameter | Type | Description |
|-----------|------|--------------|
| cmd-name | symbol | The name of the command |

Returns: The command function, or null

```clojure
((|> file) '-r' '/')
```

```clojure
((|> grep) '-n' '^rkit$')
```
</details>

<details open>
<summary>>></summary>

> Creates and registers a 5hell macro.

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
<summary>defaultvalue</summary>

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

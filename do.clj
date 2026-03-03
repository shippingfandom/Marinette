;; Resource configuration using the Glosure programming language!
;; * Much like ordinary do.rc! But with Glosure syntax and macros applied ^.^
;; 
;; * Commands use the following syntax:
;; -- ((|> command-name) arg1 arg2 arg3 arg4)
;; --eg: ((|> echo) 'hello' 'Marinette' 'users!' '<3')
;; 
;; * Piping works! Just the different syntax:
;; -- (def command1-result ((|> command1) arg1 ...))
;; -- ((|> command2) command1-result ...)
;; --eg: To be written soon...
;; 
;; * Macros use the following syntax:
;; -- To define a macro:
;; ---- (>> macroname @pipe body)
;; ----eg: (>> hello @pipe ((|> echo) 'hello world!'))
;; -- To evaluate a macro:
;; ---- ((|> macro) 'macroname')
;; ----eg: ((|> macro) 'hello')
;; 
;; NOTE: Unlike do.rc, you can't place any Marinette part to Config!
;; -- To have 'home' and 'away' functionality, read stack_pool at cob
;; -- If it is zero, we're at home, else away. Should be simple! <3




;; Comment this if you don't want your macros to be sorted
;; By default, Marinette will sort macros
(mari-sort-macros)

;; Create a theme file in rkit/marinette/themes
;; Then change the string to your file name like this:
;; (mari-load-theme 'your-amazing-theme.src')
;; By default, Marinette will attempt to load soft theme
(mari-load-theme 'soft.src')

;; Configure HOME server if you would like to have one!
;; By default, Marinette doesn't have anything configured as your HOME server
;; (set (@ HOME) 'ip' 'ip.add.rr.ess')
;; (set (@ HOME) 'loginport' 22)
;; (set (@ HOME) 'rshellport' 1222)
;; (set (@ HOME) 'pass' 'password')

;; Update hacking libraries in /lib and rkit at startup
;; By default, hacking libraries will be updated if the following is in order:
;; -- We are at stack_pool 0
;; -- We have aptclient loaded
;; -- There is active network connection
;; -- There is a repository with up to date libraries
;; -- There are libraries that need updating
(mari-update-hacking-libraries)

(gl-break-silence '[MariConf] Marinette config v0.1.4 is successfully loaded! \\(^.^)/')

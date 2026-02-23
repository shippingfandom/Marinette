;; 
;; Standard Glosure Library, modified
;; 

;; Define undefined variable or use value of the defined one
(defmacro defdefault (name value) ()
    (def name
        (if (hasIndex (context) (quote name))
            name
            value)))

;; Define named lambda
(defmacro defun (name arguments body) ()
    (def name (lambda arguments body)))

;; Define named glosure
(defmacro defunction (name arguments body) ()
    (def name (glosure arguments body)))

;; While loop
(defmacro while (condition body) ()
    (if condition (loop body condition)))

;; Do while loop
(defmacro do-while (condition body) ()
    (loop body condition))

;; For loop
(defmacro for (initializer condition iterator body) () (begin
    initializer
    (if condition (loop body iterator condition))))

;; Foreach loop
(defmacro foreach (key value collection body) (!keys) (begin
    (defdefault !keys (array))
    (push !keys (indexes collection))
    (if (at !keys (to_int '-1'))
        (loop
            (def key (pull (at !keys (to_int '-1'))))
            (def value (at collection key))
            body
            (at !keys (to_int '-1'))))
    (pop !keys)))

;; Rebind keyword
(defmacro defalias (name keyword) ()
    (defmacro name () () keyword))

;; Swap two variables
(defmacro swap (a b) (!temp) (begin
    (def !temp a)
    (def a b)
    (def b !temp)))

;; Preincrement
(defmacro ++ (var) ()
    (def var (+ var 1)))

;; Postincrement
(defmacro var++ (var) (!temp) (begin
    (def !temp var)
    (def var (+ var 1))
    !temp))

;; Predecrement
(defmacro -- (var) ()
    (def var (- var 1)))

;; Postdecrement
(defmacro var-- (var) (!temp) (begin
    (def !temp var)
    (def var (- var 1))
    !temp))

;; Useless gensym
(defun gensym ()
    (exec '(defmacro _ () (sym) (quote sym))(_)')) ;; Unquote is needed to make it any usefull




;; 
;; 5hell Glosure Library
;;

;; Get COB variable
(defmacro @ (var-name) ()
    (if (hasIndex (get_custom_object) (quote var-name))
        (at (get_custom_object) (quote var-name))))

;; Set COB variable
(defmacro @= (var-name var-value) ()
    (set (get_custom_object) (quote var-name) var-value))

;; Get globals variable
(defmacro : (var-name) ()
    (if (hasIndex globals (quote var-name))
        (at globals (quote var-name))))

;; Set globals variable
(defmacro := (var-name var-value) ()
    (set globals (quote var-name) var-value))

;; Get globals.command command
(defmacro |> (cmd-name) ()
    (if (hasIndex (: command) (quote cmd-name))
        (at (: command) (quote cmd-name))))

;; Sets globals.command.cmd-name
(defmacro |= (cmd-name cmd-args cmd-body) () (begin
    (defunction cmd-name cmd-args cmd-body)
    ((lambda () (begin
        (def commands (: command))
        (set commands (quote cmd-name) cmd-name)
        (:= command commands))))))

;; Get miniscript's object method
(defmacro _ (object method) ()
    (at object (quote method)))

;; Break through globals.SILENT and print()
(defun gl-break-silence (message) (begin
    (def silent-state (: SILENT))
    (if (!= silent-state 0)
        (:= SILENT 0))
    (print message)
    (:= SILENT silent-state)
    message))

;; Greps into every step from previous step and returns a file if successfull
(defun gl-grep-into (steps) (begin
    (def from ((|> file) '-r' '/'))
    (foreach _ step steps
        (if (== (typeof from) 'file')
            (def from ((|> grep) '-f' step from))))
    (if (== (typeof from) 'file')
        from)))

;; Concats file paths
(defun gl-pathcat (paths) (begin
    (def path (pull paths))
    (foreach _ part paths
        (def path (join (array path part) '/')))
    (if (== '//' (slice path 0 2))
        (slice path 2 (len path)))
        path))

;; Generates random string of specified length
(defun gl-random-string (length) (begin
    (def abc 'acdfeghhijklmnopqrstuvwxyz')
    (def abc (+ abc (upper abc)))
    (def return-string '')
    (for (def i 0) (< i length) (++ i) (begin
        (def characters (values abc))
        (shuffle characters)
        (def character (pull characters))
        (def return-string (+ return-string character))))
    return-string))




;; Init
(gl-break-silence '[5GL] 5hell Glosure library is successfully loaded! \\(^.^)/')

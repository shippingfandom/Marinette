;; This script will set you up the 5hell from scratch when starting off!
;; It also demonstrates how you cat define variables with 'def' keyword
;; and invoke 5hell commands with |> macro <3

;; Unlock the system for air
;; You can always lock back again with kore (I think? Maybe not kore...)
((|> macro) 'unlock' 'y')

;; Get access to the network
((|> air))

;; Get random repository
(def address ((|> netstalk) 'repository'))

;; Add this repository and update libraries
((|> aptm) '-a' address)
((|> aptm) '-U')
((|> aptm) '-i' 'crypto.so')
((|> aptm) '-i' 'metaxploit.so')
((|> aptm) '-i' 'blockchain.so')

;; Fill rkit with updates libraries
((|> kore) '-r')

;; Load updated libraries into the memory
((|> aptm) '--hotswap')

;; Get a proxy network consisting of 5 machines
((|> kraken) '-r' '5')

# Readme

## Multipart file sender

Send data to http://localhost:8080/receiver with 3 types of multipart data:
* Products (id: products) list
    * id
    * name
    * description
* Params (id: params) maps
    * key: string
    * value: string
* Files (id: files) list
    * PDF files

The files read from /resources directory, the rest from the Producer class

## Multipart file receiver

Listen on port http://localhost:8080/receiver for 3 types of multipart data:
* Products (id: products) list
  * id
  * name
  * description
* Params (id: params) maps
  * key: string
  * value: string
* Files (id: files) list
  * PDF files

The received data will be written on to disk:
* /tmp directory
#!/bin/sh

curl -v -H "Accept: application/json"  -H "Content-Type: application/json" --data @b.json http://localhost:8080/beacon/events

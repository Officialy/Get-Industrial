#!/bin/sh

while [[ $# -gt 0 ]]
do
  ITEMNAME="$1"
  FILEPATH="./src/main/resources/assets/getindustrial/models/item/${ITEMNAME}.json"
  if [[ -f "$FILEPATH" ]]; then
    echo "$FILEPATH already exists"
    shift
    continue
  fi
  echo "{" >> "$FILEPATH"
  echo "  \"parent\": \"item/generated\"," >> "$FILEPATH"
  echo "  \"textures\": {" >> "$FILEPATH"
  echo "    \"layer0\": \"getindustrial:items/${ITEMNAME}\"" >> "$FILEPATH"
  echo "  }" >> "$FILEPATH"
  echo "}" >> "$FILEPATH"
  shift
done
sleep 1
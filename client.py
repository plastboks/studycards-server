#!/bin/python
#
# Simple python client
#

import requests
import json
import uuid

base_url = 'http://localhost:8080/'

payload = {'email': '%s@plastboks.net' % str(uuid.uuid4()), 'password': 1234}
register = requests.post(base_url + 'students',
                         data=json.dumps(payload))

callback = json.loads(register.text)
colloquium_url = callback['_links']['colloquia']['href']

colloquium_req = requests.get(colloquium_url)

print(register.text)
print(colloquium_req.text)

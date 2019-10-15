# ELK-POC
A POC for sending log to elk

use GELF format

configuration for logstash:

input {
  gelf {}
}

output {
  elasticsearch {
    hosts => ["http://localhost:9200"]
  }
  stdout {}
}

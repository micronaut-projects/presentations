#!/bin/bash
EXIT_STATUS=0
./gradlew :app:buildNativeLambda || EXIT_STATUS=$?
if [ $EXIT_STATUS -ne 0 ]; then
  exit $EXIT_STATUS
fi
./gradlew test || EXIT_STATUS=$?
if [ $EXIT_STATUS -ne 0 ]; then
  exit $EXIT_STATUS
fi
cd infra
cdk synth --quiet true
cdk deploy --require-approval never
cd ..
STACK_NAME=MicronautAppStack
API_URL="$(aws cloudformation describe-stacks --stack-name $STACK_NAME --query 'Stacks[0].Outputs[?OutputKey==`MnTestApiUrl`].OutputValue' --output text)"
RESPONSE="$(curl -s $API_URL)"
EXPECTED_RESPONSE='{"message":"Hello World"}'
if [ "$RESPONSE" != "$EXPECTED_RESPONSE" ]; then echo $RESPONSE && exit 1; fi
echo "success"
exit $EXIT_STATUS

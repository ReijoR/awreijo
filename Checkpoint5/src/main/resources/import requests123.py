import requests
from google.cloud import storage

def transfer_image(request):
    # Download the image from the URL
    response = requests.get("https://cataas.com/cat/says/hello%20world!")
    image_data = response.content

    # Save the image to a Google Cloud Storage bucket
    client = storage.Client()
    bucket = client.bucket("reijonampari2")
    blob = bucket.blob("random-image.jpg")
    blob.upload_from_string(image_data, content_type="image/jpeg")
    
    return "Transferred"



ja ____

google-cloud-storage
requests




resources:
  - name: image-bucket
    type: gcs.bucket
    properties:
      bucket: reijonampari2


steps:
  - name: josnyttoimis
    action: gcp.functions.create
    properties:
      functionName: mustavalko
      region: us-central1
      triggerEventType: google.storage.object.finalize
      triggerResource: $(resources.image-bucket.name)
      entryPoint: black_and_white

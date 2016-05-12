json.array!(@offers) do |offer|
  json.extract! offer, :id, :title, :description, :activated_at
  json.url offer_url(offer, format: :json)
end

json.array!(@offers) do |offer|
  json.extract! offer, :id, :title, :description, :published_at, :price
  json.url offer_url(offer, format: :json)
end
